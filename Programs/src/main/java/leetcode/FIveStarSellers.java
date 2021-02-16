package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FIveStarSellers {

    public static void main(String[] args){
        int[][] p = {{4,4},{1,2},{3,6}};
        System.out.println(fiveStarReviews(p,77));
    }
        public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {

            int  n = productRatings.length;
            double current = 0;
            int count = 0;
            //PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingDouble(a -> calculate(productRatings, a)));
            double[] perc = new double[n];
            for(int i = 0 ; i < n ; i++){

                double contribution = calculate(productRatings,i);
                current+=contribution;
                perc[i] = contribution;
                //q.add(i);
            }

            current = current/n;

            while(current*100<ratingsThreshold){

                int ind = 0;
                double maxDiff = 0;
                for(int i = 0 ; i < n ; i++){
                    double temp = (productRatings[i][0]+1.0)/(productRatings[i][1]+1.0);
                    double diff = temp - perc[i];
                    if(diff > maxDiff){
                        maxDiff = diff;
                        ind = i;
                    }
                }


                current = current*n;
                current -= perc[ind];
                productRatings[ind][0]++ ;
                productRatings[ind][1]++ ;
                double contribuiton = calculate(productRatings,ind);
                System.out.println(contribuiton);
                current+=contribuiton;
                current = current/n;
                perc[ind] = contribuiton;
                count++;

            }
            return count;
        }

        public static  double calculate(int[][] p, int i){
            return (p[i][0]*1.0)/p[i][1];
        }
    }

