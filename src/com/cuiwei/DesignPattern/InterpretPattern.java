package com.cuiwei.DesignPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * created by cuiwei on 2018/9/23
 * 解释器模式
 * 中英翻译器
 */
public class InterpretPattern {
    public static void main(String[] args) {
        String english = "this is an apple.Is right?";
        Translator translator = new Translator();
        String chinese = translator.translate(english);
        System.out.println(chinese);
    }

}

interface IExpression{
    void interpret(String ch,StringBuilder sb);
}

class WordExpression implements IExpression{
    @Override
    public void interpret(String ch, StringBuilder sb) {
        sb.append(ChineseEnglishDict.getChinese(ch.toLowerCase()));
    }
}

class SymbolExpression implements IExpression{
    @Override
    public void interpret(String sign, StringBuilder sb) {
        switch (sign){
            case ".":
                sb.append("。");
                break;
            case "?":
                sb.append("？");
                break;
        }
    }
}
class ChineseEnglishDict{
    private static HashMap<String,String> dict = new HashMap<>();
    static {
        dict.put("this","这");
        dict.put("is","是");
        dict.put("an","一个");
        dict.put("apple","苹果");
        dict.put(".","。");
        dict.put("Is","对");
        dict.put("right","吗");
        dict.put("?","？");
    }
    public static String getChinese(String english){
        return dict.get(english);
    }
}

class Translator{
    private static Map<String,IExpression> expressions = new HashMap<>();

    static {
        expressions.put("word",new WordExpression());
        expressions.put("symbol",new SymbolExpression());
    }
    public String translate(String sentence){
        StringBuilder result = new StringBuilder();
        String[] subSentences = sentence.split("\\.");
        IExpression wordExpression = expressions.get("word");
        IExpression symExpression = expressions.get("symbol");
        for (String subSentence : subSentences){
            boolean isJuhaoSymol = true;
            String[] words = subSentence.split(" ");
            for (String word : words){
                char lastChar = word.charAt(word.length() -  1);
                String sign = "";
                if (lastChar == '?') {
                    word = word.substring(0,word.length() - 1);
                    sign = String.valueOf(lastChar);
                    isJuhaoSymol = false;
                }
                wordExpression.interpret(word,result);
                if (!sign .equals("")) symExpression.interpret(sign,result);
            }
            if (isJuhaoSymol)
                symExpression.interpret(".",result);
        }
        return result.toString();
    }
}