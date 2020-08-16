public class BestTimeToBuySellStock4 {

        public int maxProfit(int k, int[] prices) {

            //case 1 :
            int n = prices.length;
            if (n == 0 || k==0) return 0;

            // case 2 : same as infinite no of transactions possible, keep doing if  price[i] > price[i-1]
            if (2*k > n) {
                int res = 0;
                for (int i = 1; i < n; i++) {
                    res += Math.max(0, prices[i] - prices[i - 1]);
                }
                return res;
            }
            // case 3 : maintain states ( 2 per transaction )
            int[] states = new int[k*2];
            states[0] = -prices[0];
            for(int i = 1 ; i< states.length ; i++)
                states[i] = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                states[0] = Math.max(states[0], -prices[i]);
                for(int j = 1 ; j < states.length; j++){
                    if(j%2==0) // buy
                        states[j] = Math.max(states[j], states[j-1] - prices[i]);
                    else // sell
                        states[j] = Math.max(states[j], states[j-1] + prices[i]);
                }
            }

            return Math.max(0, states[states.length-1]);
        }
    }
