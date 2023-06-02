
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" | " + arr[i][j] + " | ");
            }
            System.out.println("");
        }
        int hang, cot;
        boolean trungLap;
        boolean soSanh = true;
        int soBuocThang = 4;
        int[] dieuKienHang = {-1, 0, -1, -1};
        int[] dieuKienCot = {0, -1, -1, 1};

        for (int k = 0; k < 49; k++) {
            do {
                trungLap = true;
                do {
                    System.out.println("Nguoi choi 1");
                    System.out.print("Nguoi choi 1 nhap vao gia tri hang: ");
                    hang = scanner.nextInt();
                    System.out.print("Nguoi choi 1 nhap vao gia tri cot: ");
                    cot = scanner.nextInt();
                } while (hang > 10 || cot > 10);
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (i == hang - 1 && j == cot - 1) {
                            if (arr[i][j] != 0) {
                                System.out.println("Vi tri da duoc chon moi nhap lai");
                                trungLap = false;
                                break;
                            } else {
                                arr[i][j] = 1;
                            }
                        }
                    }
                }
            } while (!trungLap);
            System.out.println("Ban co voi gia tri moi:");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(" | " + arr[i][j] + " | ");
                }
                System.out.println("");
            }
            int hangIndex = hang - 1;
            int cotIndex = cot - 1;
            for (int i = 0; i < dieuKienHang.length; i++) {
                int hangHienTai = 0;
                int cotHienTai = 0;
                int count = 0;
                for (int j = 1; j <= soBuocThang * 2 - 1; j++) {
                    if (j == 1) {
                        hangHienTai = hangIndex + (dieuKienHang[i] * (soBuocThang - 1));
                        cotHienTai = cotIndex + (dieuKienCot[i] * (soBuocThang - 1));
                    } else {
                        hangHienTai = hangHienTai + (-dieuKienHang[i]);
                        cotHienTai = cotHienTai + (-dieuKienCot[i]);
                    }
                    if (hangHienTai < 0 || hangHienTai >= 10) {
                        continue;
                    }
                    if (cotHienTai < 0 || cotHienTai >= 10) {
                        continue;
                    }
//                    System.out.println(hangHienTai + "-" + cotHienTai);
                    if (arr[hangHienTai][cotHienTai] == 1) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == soBuocThang) {
                        soSanh = false;
                        break;
                    }
                }
            }
            if (!soSanh) {
                System.out.println("Nguoi choi mot chien thang");
                break;
            }
            do {
                trungLap = true;
                do {
                    System.out.println("Nguoi choi 2");
                    System.out.print("Nguoi choi 2 nhap vao gia tri hang: ");
                    hang = scanner.nextInt();
                    System.out.print("Nguoi choi 2 nhap vao gia tri cot: ");
                    cot = scanner.nextInt();
                } while (hang > 10 || cot > 10);
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (i == hang - 1 && j == cot - 1) {
                            if (arr[i][j] != 0) {
                                System.out.println("Vi tri da duoc chon moi nhap lai");
                                trungLap = false;
                                break;
                            } else {
                                arr[i][j] = 2;
                            }
                        }
                    }
                }
            } while (!trungLap);
            System.out.println("Ban co voi gia tri moi");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(" | " + arr[i][j] + " | ");
                }
                System.out.println("");
            }
            int hangIndex2 = hang - 1;
            int cotIndex2 = cot - 1;
            for (int i = 0; i < dieuKienHang.length; i++) {
                int hangHienTai = 0;
                int cotHienTai = 0;
                int count = 0;
                for (int j = 1; j <= soBuocThang * 2 - 1; j++) {
                    if (j == 1) {
                        hangHienTai = hangIndex2 + (dieuKienHang[i] * (soBuocThang - 1));
                        cotHienTai = cotIndex2 + (dieuKienCot[i] * (soBuocThang - 1));
                    } else {
                        hangHienTai = hangHienTai + (-dieuKienHang[i]);
                        cotHienTai = cotHienTai + (-dieuKienCot[i]);
                    }
                    if (hangHienTai < 0 || hangHienTai >= 10) {
                        continue;
                    }
                    if (cotHienTai < 0 || cotHienTai >= 10) {
                        continue;
                    }
//                    System.out.println(hangHienTai + "-" + cotHienTai);
                    if (arr[hangHienTai][cotHienTai] == 2) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count == soBuocThang) {
                        soSanh = false;
                        break;
                    }
                }
            }
            if (!soSanh) {
                System.out.println("Nguoi choi hai chien thang");
                break;
            }
        }
        if (soSanh){
            System.out.println("Hoa nhau");
        }
    }
}

