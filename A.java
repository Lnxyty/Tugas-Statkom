/**
 * Kode disusun oleh:
 * Joshua Adriel Suhandi - 6182501026
 * Fachri Ahmad Hanif - 6182501004
 */
import java.util.Scanner;
import java.lang.Math;
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
     * 
     * @param arr
     * @return
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
     * 
     * @param arr
     * @return
     */
    public static double median(double arr[])
    {
        int mid = (arr.length) / 2;
        double med = arr[mid] + (0.5 * (arr[mid+1] - arr[mid]));
        return med;
    }

    /**
     * 
     * @param arr
     * @param mean
     * @return
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
     * 
     * @param validitas
     * @param arr
     * @return
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
     * 
     * @param arr
     * @return
     */
    public static double[] quartileArr(double arr[])
    {
        double q[] = new double[3];
        q[0] = arr[((arr.length + 1) / 4) - 1];
        q[1] = arr[((arr.length + 1) / 2) - 1];
        q[2] = arr[(((arr.length + 1) * 3) / 4) - 1];

        return q;
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
        ValiditasMaxMin = operasiValiditasMaxMin(ValiditasMaxMin,arr); // jujur aku malas buat metode buat satu satu 
        double median = median(arr);
        double simpanganBaku = simpanganBaku(arr, mean);
        double quartile[] = quartileArr(arr);

        // Output akhir
        System.out.printf("Jumlah data valid: %d%n", (int)ValiditasMaxMin[0]);
        System.out.printf("Mean: %.2f%n", mean); // Output mean
        System.out.printf("Median: %.2f%n", median);
        System.out.printf("s: %.2f%n", simpanganBaku);
        System.out.printf("Min: %.2f%n", ValiditasMaxMin[2]);
        System.out.printf("Q1: %.2f%n", quartile[0]);
        System.out.printf("Q3: %.2f%n", quartile[2]);
        System.out.printf("Max: %.2f%n", ValiditasMaxMin[1]);

        sc.close(); // Menutup scanner;
    }
}