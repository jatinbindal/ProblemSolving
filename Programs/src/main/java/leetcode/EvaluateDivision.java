package leetcode;

import java.util.*;

//equation given as a/b = 2 ; b/c = 5 .. etc... graph problem
// note : division by zero is allowed for double
public class EvaluateDivision {

        Map<String, Map<String,Double>> map =  new HashMap<>();

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            double[] results = new double[queries.size()];

            for(int i=0;i<equations.size();i++) {
                buildGraph(equations.get(i),values[i]);
            }

            for(int i=0;i<queries.size();i++) {

                results[i] = calculateQueryResult(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>());

            }

            return results;

        }

        private void buildGraph(List<String> equation, double result) {

            String start = equation.get(0);
            String end = equation.get(1);

            map.putIfAbsent(start, new HashMap<>());

            map.get(start).put(end,result);

            map.putIfAbsent(end, new HashMap<>());

            map.get(end).put(start,1/result);
        }

        private double calculateQueryResult(String start, String end , Set<String> visited) {

            if(!map.containsKey(start) || !map.containsKey(end)) {
                return -1.0;
            }

            if(start.equals(end)) {
                return 1.0;
            }

            if(map.get(start).containsKey(end)) {
                return map.get(start).get(end);
            }

            visited.add(start);

            for(Map.Entry<String,Double> entry : map.get(start).entrySet()) {
                if(!visited.contains(entry.getKey())) {
                    double d = calculateQueryResult(entry.getKey(),end,visited);
                    if( d!=-1.0) {
                        d = d* entry.getValue();
                        return d;
                    }
                }
            }

            return -1.0;

        }
    }
