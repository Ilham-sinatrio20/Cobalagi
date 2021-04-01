package First;

import java.text.DecimalFormat;

/**
 *
 * @author LENOVO
 */
public class Data {
    public String[] nama, induk;
    public float[] nilai1, nilai2, nilai3, rata;
    DecimalFormat df = new DecimalFormat("#.##");
    public Data(String[] name, String[] NIM, float[] point1, float[] point2, float[] point3,
            float[] rerata){
        nama = name;
        induk = NIM;
        nilai1 = point1;
        nilai2 = point2;
        nilai3 = point3;
        rata = rerata;
    }
    
    public void bubbleSort(){
        for(int i=0;i<nama.length-1;i++){
            for(int j=1;j<(nama.length-i);j++){
                if(nilai1[j] > nilai1[j-1]){
                //Nilai 1
                float temp = nilai1[j];
                nilai1[j] = nilai1[j-1];
                nilai1[j-1] = temp;
                //Nilai 2
                float n2 = nilai2[j];
                nilai2[j] = nilai2[j-1];
                nilai2[j-1] = n2;
                //Nilai 3
                float n3 = nilai3[j];
                nilai3[j] = nilai3[j-1];
                nilai3[j-1] = n3;
                //Rata-rata
                float r = rata[j];
                rata[j] = rata[j-1];
                rata[j-1] = r;
                //Nama
                String idx = nama[j];
                nama[j] = nama[j-1];
                nama[j-1] = idx;
                }
            }
        }
    }
    
    public void selectionSort(){
        for(int i=0;i<nama.length-1;i++){
            int idxmax = i;
            for(int j=i+1;j<nama.length;j++){
                if(nilai2[j] > nilai2[idxmax]){
                idxmax = j;
                }
            }
            //Nilai 2
            float temp = nilai2[idxmax];
            nilai2[idxmax] = nilai2[i];
            nilai2[i] = temp;
            //Nilai 1
            float n1 = nilai1[idxmax];
            nilai1[idxmax] = nilai1[i];
            nilai1[i] = n1;
            //Nilai 3
            float n3 = nilai3[idxmax];
            nilai3[idxmax] = nilai3[i];
            nilai3[i] = n3;
            //Rata
            float r = rata[idxmax];
            rata[idxmax] = rata[i];
            rata[i] = r;
            //Nama
            String idx = nama[idxmax];
            nama[idxmax] = nama[i];
            nama[i] = idx;
        }
    }
    
    public void insertionSort(){
        for(int i=1;i<nama.length;i++){
            int temp = (int) nilai3[i];
            float n1 = nilai1[i];
            float n2 = nilai2[i];
            float r = rata[i];
            String na = nama[i];
            int j = i-1;
            while(j>=0 && nilai3[j] < temp){
                nilai3[j+1] = nilai3[j];
                nilai1[j+1] = nilai1[j];
                nilai2[j+1] = nilai2[j];
                rata[j+1] = rata[j];
                nama[j+1] = nama[j];
                j--;
            }
            //Nilai 3
            nilai3[j+1] = temp;
            //Nilai 1
            nilai1[j+1] = n1;
            //Nilai 2
            nilai2[j+1] = n2;
            //Rata-rata
            rata[j+1] = r;
            //Nama
            nama[j+1] = na;
        }
    }
    
    public void shellSort(){
        int gap;
        for(gap = nama.length/2;gap>0;gap/=2){
            for(int i=gap;i<nama.length;i+=1){
                float temp = rata[i];
                int n1 = (int) nilai1[i];
                int n2 = (int) nilai2[i];
                int n3 = (int) nilai3[i];
                String n = nama[i];
                int j;
                for(j=i;j>=gap && rata[j-gap]<temp;j-=gap){
                    rata[j] = rata[j-gap];
                    nama[j] = nama[j-gap];
                    nilai1[j] = nilai1[j-gap];
                    nilai2[j] = nilai2[j-gap];
                    nilai3[j] = nilai3[j-gap];
                }
                //Rata-rata
                rata[j]=temp;
                //Nilai 1
                nilai1[j]=n1;
                //Nilai 2
                nilai2[j]=n2;
                //Nilai 3
                nilai3[j]=n3;
                //Nama
                nama[j] = n;
            }
        }
    }
    
    public int searching(float letak){
        int posisi = 0;
        for(int i=0;i<nama.length;i++){
            if(letak == rata[i]){
                posisi = i;
                break;
            }
        }
        return posisi;
    }
    
    public void tampil(){
        System.out.println("===============================================================");
        System.out.println("=================== Hasil Rekap Nilai Siswa ===================");
        System.out.println("===============================================================");
        System.out.println("No" + " Nama \t " + "Nilai1 " + "Nilai2 " + "Nilai3 " + "Rata");
        for(int i=0;i<nama.length;i++){
            System.out.print((i+1) + ". " + nama[i] + "  \t " + nilai1[i] + " \t " + nilai2[i] + 
                    " \t " + nilai3[i] + "\t" + df.format(rata[i]));
            System.out.println();
        }
        System.out.println("===============================================================");
        System.out.println();
    }
}
