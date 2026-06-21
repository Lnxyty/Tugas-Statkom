/**
 * Kode disusun oleh:
 * Joshua Adriel Suhandi - 6182501026
 * Fachri Ahmad Hanif - 6182501004
 */
import java.util.ArrayList;
import java.util.Scanner;
public class A {
    /**
     * Sorting array dari yang terkecil ke terbesar
     * @param arr = kumpulan data yang ingin diolah
     * @return arr yang sudah disorting kembali
     */
    public static double[] sorting(double arr[])
    {
        // Metode sorting: Selection sort
        for (int i = 0; i < arr.length - 1; i++)
        {
            double min = arr[i];
            int pos = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < min)
                {
                    min = arr[j];
                    pos = j;
                }
            }
            double temp = arr[i];
            arr[i] = min;
            arr[pos] = temp;
        }

        return arr;
    }

    /**
     * Mencari rata-rata
     * @param arr = array yang berisi data-data input
     * @return hasil perhitungan mean
     */
    public static double operasiMean (double[]arr){
        double jumlahAkumulatif = 0;
        for (int q = 0 ; q < arr.length ; q++ ){
            jumlahAkumulatif += arr[q];
        }
        jumlahAkumulatif /= arr.length;
        return jumlahAkumulatif;
    }

    /**
     * Mencari median
     * @param arr = array berisi data-data input
     * @return nilai median
     */
    public static double median(double arr[])
    {
        int mid = (arr.length) / 2;
        double med = arr[mid] + (0.5 * (arr[mid+1] - arr[mid]));
        return med;
    }

    /**
     * Mencari simpangan baku
     * @param arr = array yang berisi data-data
     * @param mean = nilai rata-rata yang kita dapatkan
     * @return nilai simpangan baku
     */
    public static double simpanganBaku(double arr[], double mean) 
    {
        double res = 0;
        for (int i = 0; i < arr.length; i++)
        {
            res += ((arr[i] - mean) * (arr[i] - mean));
        }
        res /= arr.length;

        return Math.sqrt(res);
    }

    /**
     * Mencari jumlah data valid, min dan max
     * indeks 0 = jumlah data valid
     * indeks 1 = angka min
     * indeks 2 = angka max
     * @param validitas = array untuk menyimpan semua hasilnya
     * @param arr = array berisi data-data
     * @return array dari variabel validitas
     */
    public static double[] operasiValiditasMaxMin (double[]validitas,double []arr){
        double validitasAkumulatif = 0;
        double maximumNilai = 0;
        double minimumNilai = Double.MAX_VALUE;
        for (int q = 0 ; q < arr.length ;q++){
            if (arr[q]!= 0){
                validitasAkumulatif++;
            }
            if (arr[q]> maximumNilai){
             maximumNilai = arr[q];
            }
            if (arr[q] < minimumNilai){
                minimumNilai = arr[q];
            }
        }
        validitas[0]= validitasAkumulatif;
        validitas[1] = maximumNilai;
        validitas[2]= minimumNilai;

        return validitas;
    }

    /**
     * Mencari Q1, Q2 dan Q3
     * Nilai Q1 ada di indeks 0
     * Nilai Q2 ada di indeks 1
     * Nilai Q3 ada di indeks 2
     * @param arr = array berisi data-data input
     * @return array berisi nilai-nilai quartile
     */
    public static double[] quartileArr(double arr[])
    {
        double q[] = new double[3];
        q[0] = arr[((arr.length + 1) / 4) - 1];
        q[1] = arr[((arr.length + 1) / 2) - 1];
        q[2] = arr[(((arr.length + 1) * 3) / 4) - 1];

        return q;
    }

    /**
     * Mencari outlier-outlier yang ada
     * @param arr = array berisi data-data input
     * @param IQR = nilai dari interquartile range yang sudah kita hitung
     * @param Q1 = nilai dari q1
     * @param Q3 = nilai dari q2
     * @return ArrayList yang berisi data-data yang dianggap sebagai outlier
     */
     public static ArrayList<Double> searchingformyops(double arr[], double IQR, double Q1 , double Q3)
    {
        ArrayList<Double> outlier = new ArrayList<>();
        for (int q = 0 ; q < arr.length ;q++){
            if (arr[q]< Q1 - (1.5*(IQR)) ){
                outlier.add(arr[q]);
            }
            else if (arr[q]> Q3 + (1.5*(IQR))){
                outlier.add(arr[q]);
            }
        }

        return outlier ;
    }
    
    public static void main(String[] args) {
        // Input data
        Scanner sc = new Scanner(System.in); // Import scanner
        double arr[] = new double[24]; // Array untuk menyimpan nilai-nilai datanya
        // Looping untuk memasukkan setiap data ke dalam array
        for (int i = 0; i < 24; i++)
        {
            arr[i] = sc.nextDouble();
        }

        // Mengolah data
        arr = sorting(arr); // Menyortir array terlebih dahulu dari yang terkecil ke terbesar
        double mean = operasiMean(arr);  // call operasi yang mencari mean
        double [] ValiditasMaxMin = new double[3];  // array untuk menentukan 3 hal yaitu validitas , nilai Maximum , dan nilai minimum 
        ValiditasMaxMin = operasiValiditasMaxMin(ValiditasMaxMin,arr); 
        double median = median(arr);
        double simpanganBaku = simpanganBaku(arr, mean);
        double quartile[] = quartileArr(arr);
        double IQR = quartile[2] - quartile[0];
        ArrayList<Double> outlier = new ArrayList<>();
        outlier = searchingformyops(arr,  IQR, quartile[0], quartile[2]);
        int outlierTotal = outlier.size();
        int n = 1 ;

        // Output akhir
        System.out.printf("Jumlah data valid: %d%n", (int)ValiditasMaxMin[0]);
        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Median: %.2f%n", median);
        System.out.printf("s: %.2f%n", simpanganBaku);
        System.out.printf("Min: %.2f%n", ValiditasMaxMin[2]);
        System.out.printf("Q1: %.2f%n", quartile[0]);
        System.out.printf("Q3: %.2f%n", quartile[2]);
        System.out.printf("Max: %.2f%n", ValiditasMaxMin[1]);
        System.out.printf("IQR: %.2f%n", IQR);
        System.out.printf("Outlier: %d%n", outlierTotal);
        // Looping untuk output dari data-data outlier
        for (double x : outlier) {
            System.out.printf("Outlier %d: %.2f%n", n,x);
            n++;
        }

        sc.close(); // Menutup scanner;
    }
}