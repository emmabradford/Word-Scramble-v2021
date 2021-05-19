import java.util.*;
/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordScramble
{
    /** Scrambles a given word
     *  @param word the word to be scrambled
     *  @return the scrambled word (possibly equal to word)
     *  Precondition: word is either an empty string or contains only uppercase letters.
     *  Postcondition: the string returned was created from word as follows:
     *   - the word was scrambled, beginning at the first letter and continuing from left to right
     *   - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     *   - letters were swapped at most once
     */
    public static String scrambleWord(String word)
    { 
        String result = "";
        int curr = 0;
        
        while(curr < word.length() - 1)
        {
            if(word.substring(curr, curr + 1).equals("A") && !word.substring(curr + 1, curr + 2).equals("A"))
            {
                result += word.substring(curr + 1, curr + 2);
                result += "A";
                curr += 2;
            }
            else
            {
                result += word.substring(curr, curr + 1);
                curr++;
            }
        }
        if (curr < word.length())
        {
            result += word.substring(curr);
        }
        return result;  // replace this line
    }

    /** Modifies wordlist by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *  @param wordList the list of words.
     *   Precondition: wordList contains only non-null objects
     *   Postcondition:
     *     - all words unchanged by scrambling have been removed from wordList
     *     - each of the remaining words has been replaced by its scrambled version
     *     - the relative ordering of the entries in wordList is the same as it as was 
     *          before the method was called
     */
    public static void scrambleOrRemove(List<String> wordList)
    {
        int i = 0;
        while(i < wordList.size())
        {
            String word = wordList.get(i);
            String scrambled = scrambleWord(word);
            if(word.equals(scrambled))
            {
                wordList.remove(i);
            } 
            else
            {
                wordList.set(i, scrambled);
                i++;
            }
        }
    } 
}
