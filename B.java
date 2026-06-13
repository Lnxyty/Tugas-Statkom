import java.util.Scanner;
public class B {
    /*
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
    public static double operasiMean (double[]arr){
        double jumlahAkumulatif = 0;
        for (int q = 0 ; q < arr.length ; q++ ){
            jumlahAkumulatif += arr[q];
        }
        jumlahAkumulatif /= arr.length;
        return jumlahAkumulatif;
    }
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
    public static void main(String[] args) {
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
     
 



        System.out.println(mean+"yes");    // untuk output mau dimasukin ke metode aja gitu>=?
        System.out.println(ValiditasMaxMin[0]+"yes");
        System.out.println(ValiditasMaxMin[1]+"yes");
        System.out.println(ValiditasMaxMin[2]+"yes");
        
        


        sc.close(); // Menutup scanner;
    }
}
