package com.vineethds.others;

import java.util.ArrayList;
import java.util.Scanner;

public class Peanut {
    private static boolean isPeanutInsideBag(double x1, double y1, double x2, double y2, double p1, double p2) {
        return p1 >= x1 && p2 >= y1 && p1 <= x2 && p2 <= y2;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            ArrayList<String> boxes = new ArrayList<>();
            ArrayList<String> position = new ArrayList<>();
            int cases = scan.nextInt();
            if(cases ==0)
                break;
            scan.nextLine();
            for(int i = 0; i < cases; i++){
                boxes.add(scan.nextLine());
            }
            int n =  scan.nextInt();
            scan.nextLine();
            for(int i = 0; i < n; i++){
                position.add(scan.nextLine());
            }
            for(String peanut : position){
                String[] pea = peanut.split(" " );
                double x = Double.parseDouble(pea[0]);
                double y = Double.parseDouble(pea[1]);
                String peaSize = pea[2];
                for(String box : boxes){
                String[] b = box.split(" ");
                    double x1 = Double.parseDouble(b[0]);
                    double y1 = Double.parseDouble(b[1]);
                    double x2 = Double.parseDouble(b[2]);
                    double y2 = Double.parseDouble(b[3]);
                    String boxSize = b[4];
                    boolean res = isPeanutInsideBag(x1,y1,x2,y2,x,y);
                    if(!res && boxSize.equals(peaSize)){
                        System.out.println(peaSize+" floor");
                        break;
                    }else if(res){
                        if(boxSize.equals("small") && peaSize.equals("medium")){
                            System.out.println("medium small");
                        }else if(boxSize.equals("medium") && peaSize.equals("small")){
                            System.out.println("small medium");
                        }if(boxSize.equals("small") && peaSize.equals("large")){
                            System.out.println("large small");
                        }else if(boxSize.equals("large") && peaSize.equals("small")) {
                            System.out.println("small large");
                        }if(boxSize.equals("large") && peaSize.equals("medium")){
                            System.out.println("medium large");
                        }else if(boxSize.equals("medium") && peaSize.equals("large")) {
                            System.out.println("large medium");
                        }else if(peaSize.equals(boxSize)){
                            System.out.println(peaSize+" correct");
                        }
                        break;
                    }
                }
            }


        }
    }
}
