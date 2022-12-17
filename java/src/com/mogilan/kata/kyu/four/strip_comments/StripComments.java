package com.mogilan.kata.kyu.four.strip_comments;

import java.util.ArrayList;
import java.util.Arrays;

/** https://www.codewars.com/kata/51c8e37cee245da6b40000bd
 * DESCRIPTION:
 * Complete the solution so that it strips all text that follows any of a set of comment markers
 * passed in. Any whitespace at the end of the line should also be stripped out.
 *
 * Example:
 * Given an input string of:
 * apples, pears # and bananas
 * grapes
 * bananas !apples
 *
 * The output expected would be:
 * apples, pears
 * grapes
 * bananas
 *
 * The code would be called like so:
 * var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
 * // result should == "apples, pears\ngrapes\nbananas"
 * */

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        ArrayList<Character> listOfCommentCharacters = getCharacters(commentSymbols);
        var result = new StringBuilder();
        int currentLineStartIndex = 0;
        int currentLineEndIndex;
        do {
            currentLineEndIndex = isHasNextLine (text, currentLineStartIndex) ?
                                  nextLineStartIndex (text, currentLineStartIndex) - 1:
                                  text.length() - 1;
            stripNewLine(text, listOfCommentCharacters, result, currentLineStartIndex, currentLineEndIndex);
            currentLineStartIndex = nextLineStartIndex(text, currentLineStartIndex);
        } while (currentLineEndIndex + 1 < text.length());

        return result.toString();
    }

    private static ArrayList<Character> getCharacters(String[] commentSymbols) {
        ArrayList<Character> listOfCommentCharacters = new ArrayList<>(commentSymbols.length);
        Arrays.stream(commentSymbols)
                .map(string -> string.charAt(0))
                .forEach(listOfCommentCharacters::add);
        return listOfCommentCharacters;
    }

    private static void stripNewLine(String text, ArrayList<Character> listOfCommentCharacters, StringBuilder result, int currentLineStartIndex, int currentLineEndIndex) {
        var currentLine = new StringBuilder();
        for (int i = currentLineStartIndex; i <= currentLineEndIndex; i++) {
            var currentChar = text.charAt(i);
            if(isCharBelongToListOfChar(currentChar, listOfCommentCharacters)) {
                result.append(currentLine.toString().replaceAll("\s*$", ""));
                if (isHasNextLine (text, currentLineStartIndex)) result.append('\n');
                currentLine.delete(0, currentLine.length());
                break;
            }
            currentLine.append(currentChar);
            if (i == currentLineEndIndex) {
                result.append(currentLine.toString().replaceAll("\s*$", ""));
                currentLine.delete(0, currentLine.length());
            }
        }
    }

    private static boolean isHasNextLine (String text, int currentLineStartIndex) {
        return nextLineStartIndex(text, currentLineStartIndex) > 0;
    }

    private static int nextLineStartIndex(String text, int currentLineStartIndex) {
       return text.indexOf('\n', currentLineStartIndex) + 1;
    }

    private static boolean isCharBelongToListOfChar(char currentChar, ArrayList<Character> listOfCharacters) {
        boolean result = false;
        for (Character character : listOfCharacters) {
            if(character.charValue() == currentChar) result = true;
        }
        return result;
    }
}
