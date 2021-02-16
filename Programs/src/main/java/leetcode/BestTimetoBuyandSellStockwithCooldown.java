package leetcode;

public class BestTimetoBuyandSellStockwithCooldown {


        public int maxProfit(int[] prices) {

            //State-Machine dp

            int n = prices.length;
            if(n==0)
                return 0;
            int[] zeroS = new int[n] , oneS = new int[n], twoS = new int[n];
            zeroS[0] = 0 ; oneS[0] = -prices[0] ;
            for(int i = 1; i < n; i++){

                zeroS[i] = Math.max(zeroS[i-1], twoS[i-1]);
                oneS[i] = Math.max(oneS[i-1] , zeroS[i-1] - prices[i]);
                twoS[i] = Math.max(oneS[i-1] + prices[i], twoS[i-1]);
            }

            return Math.max(zeroS[n-1] , twoS[n-1]);

        }
    }