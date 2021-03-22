package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[] {new Solution(), new Solution()};
        for (int i = 0; i<result[0].innerClasses.length; i++) {
            result[i].innerClasses[0] = result[0].new InnerClass();
            result[i].innerClasses[1] = result[1].new InnerClass();
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
