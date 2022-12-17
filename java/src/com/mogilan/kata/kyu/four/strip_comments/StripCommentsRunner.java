package com.mogilan.kata.kyu.four.strip_comments;

public class StripCommentsRunner {
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        var stripedComment = StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"!", "#"});
        System.out.println(stripedComment);
        var finish = System.currentTimeMillis();
        System.out.println("Time for completion: " + (finish - start));

        var start2 = System.currentTimeMillis();
        var stripedComment2 = StripComments.stripComments("a #b\nc\nd $e f g", new String[] { "#", "$" });
        System.out.println(stripedComment2);
        var finish2 = System.currentTimeMillis();
        System.out.println("Time for completion: " + (finish2 - start2));
    }
}
