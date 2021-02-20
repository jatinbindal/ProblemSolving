package leetcode;

public class TaskScheduler {

        public int leastInterval(char[] tasks, int k) {

            int n =  tasks.length;
            int max = 0;
            int maxCount = 1;
            int[] freq = new int[26];
            for(char t : tasks){
                int task = t -'A';
                freq[task]++;
                if(max == freq[task]){
                    maxCount++;
                }
                else if(max < freq[task]){
                    max = freq[task];
                    maxCount = 1;
                }
            }

            int slots = (max - 1);
            int eachSlotSpace = Math.max(0, k - (maxCount-1));
            int totalEmptySpace = eachSlotSpace * slots;
            int remainingTasks = n - (maxCount*max);
            int idleSpaces = Math.max(0, totalEmptySpace - remainingTasks);

            return n + idleSpaces;


        }
    }