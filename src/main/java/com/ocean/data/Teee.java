package com.ocean.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ocean.util.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/26.
 */
public class Teee {
//    public static void main(String[] args) throws Exception {
//        //加密后
//        String a = "숆ᖾ:⤩?Ὄᷘ丌*⍗Ǫ㝅??⤩?Ὄᷘ丌*⍗∘ᤃᣝ?쌘⠳⤩?Ὄᷘ丌*⍗ᅄǁᖾ:⤩?Ὄᷘ丌*⍗⍉?Ꮕ쌘⤩?Ὄᷘ丌*⍗⍉?Ꮕ쌘⤩?Ὄᷘ丌*⍗?ᾖ?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗ᜉ숫쌘⠳⤩?Ὄᷘ丌*⍗ᜉ숫쌘⠳⤩?Ὄᷘ丌*⍗ᜉ숫쌘⠳⤩?Ὄᷘ丌*⍗ᜉ숫쌘⠳⤩?Ὄᷘ丌*⍗\u2BDC\u2BDCᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌*⍗?\u2BD7ᖾ:⤩?Ὄᷘ丌쳯\u13FEᏅ:ᣍᴚ⠮ᜉ?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗쿔≧ᖾ:⤩?Ὄᷘ丌*⍗쿔≧ᖾ:⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌ᵷ\u008C⍉웵쌘⠳⤩?Ὄᷘ丌*⍗⠪?ᖾ:⤩?Ὄᷘ丌*⍗?썻ᖾ:\u1DF1ት⤩?Ὄᷘ丌*⍗?썻ᖾ:\u1DF1ት⤩?Ὄᷘ丌*⍗?썻ᖾ:\u1DF1ት⤩?Ὄᷘ丌\u2BC0?⬠ᖡ㱉썤쌘⠳⤩?Ὄᷘ丌\u2BC0?⬠ᖡ㱉썤쌘⠳⤩?Ὄᷘ丌\u2BC0?⬠ᖡ㱉썤쌘⠳⤩?Ὄᷘ丌\u2BC0?⬠ᖡ㱉썤쌘⠳⤩?Ὄᷘ丌*⍗㣻⌅ᖾ:⤩?Ὄᷘ丌*⍗㣻⌅ᖾ:⤩?Ὄᷘ丌*⍗㣻⌅ᖾ:⤩?Ὄᷘ丌*⍗㣻⌅ᖾ:⤩?Ὄᷘ丌⍗ᖡ㩾ᝅ?ቾ㟱Ⲡ⤩?Ὄᷘ丌⍗ᖡ㩾ᝅ?ቾ㟱Ⲡ⤩?Ὄᷘ丌*⍗췒콞ᖾ:⤩?Ὄᷘ丌*⍗췒콞ᖾ:⤩?Ὄᷘ丌*⍗췒콞ᖾ:⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗┇퀝?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗も쌄?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗も쌄?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗쵦?ᖾ:⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌*⍗㇜⎕ᖾ:⤩?Ὄᷘ丌*⍗㇜⎕ᖾ:⤩?Ὄᷘ丌*⍗㇜⎕ᖾ:⤩?Ὄᷘ丌⊓ᵷ\u2B90ºᖾ:⤩?Ὄᷘ丌⊓ᵷ\u2B90ºᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌⥍\u13FE찼:??㱉썤⤩?Ὄᷘ丌⥍\u13FE찼:??㱉썤⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ⱌ\u13FEᖽ⎆??⤩?Ὄᷘ丌ဘ㾿ဢၟ쇻ワ쌘⤩?쌃ÛὌᷘ丌*⍗㌋⥞㱉썤⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌\u2BC0?쉊ᤃᖾ:⤩?Ὄᷘ丌*⍗쳅?ᖾ:⤩?Ὄᷘ丌*⍗읟᭦ᖾ:⤩?Ὄᷘ丌*⍗읟᭦ᖾ:⤩?Ὄᷘ丌*⍗읟᭦ᖾ:⤩?Ὄᷘ丌*⍗읟᭦ᖾ:⤩?Ὄᷘ丌*⍗㌋⥞㱉썤⤩?Ὄᷘ丌?≿ဢ?ዐ?ቾ⥰\u2BB9⤩?Ὄᷘ丌?≿ဢ?ዐ?ቾ⥰\u2BB9⤩?Ὄᷘ丌?≿ဢ?ዐ?ቾ⥰\u2BB9⤩?Ὄᷘ丌?≿ဢ?ዐ?ቾ⥰\u2BB9⤩?Ὄᷘ丌*⍗⠪㲧ᖾ:\u1DF1ት⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗\u008D홚ᖾ:⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗ķ쇨쌘⠳⤩?Ὄᷘ丌*⍗?ⰰᖾ:⤩?Ὄᷘ丌*⍗?ⰰᖾ:⤩?Ὄᷘ丌*⍗?ⰰᖾ:⤩?Ὄᷘ丌*⍗}?⤚⚐⤩?Ὄᷘ丌*⍗}?⤚⚐⤩?Ὄᷘ丌*⍗쳯ᦺᣝ?쌘⠳⤩?Ὄᷘ丌*⍗⍉?Ꮕ쌘⤩?Ὄᷘ丌*⍗㌋⥞㱉썤⤩?Ὄᷘ丌*⍗㌋⥞㱉썤⤩?Ὄᷘ丌*⍗⍗⥞??⤩?Ὄᷘ丌*⍗⍗⥞??⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ丌쳯\u13FE튒콞??쌘⠳⤩?Ὄᷘ\n";
////加密后
//        String url = "乃乒乍与乐乕乒乃么乁乓久与乚么乁乏乇乁乎乇乒久乎乕乁乔与乃乏乍";
////        Set<String> ss = new HashSet<>();
////        for (String b : a.split(",")) {
////            ss.add(b);
////        }
////
////        for(String ab : ss){
////            System.out.println(ab);
////            String file = "src/main/resources/data/bak00913.txt";
////            FileUtils.fileChaseFW(file, ab, true);
////
////
////            getDataFromJqkaCache(ab);
////        }
////
////        System.out.println(ss.size());
//
//
//        String password = "乛丂乕乓久乒丂业乛丂乄久乐乔乮乁乍久丂业丂ᵷ\u008Cლ⥰?丂丌丂久乎乔乒乙乷乏乒之乄乁乙丂业丂丒丐丑丕不丐且不丒丗丂丌丂义乄乥乎乔义乔乙乮乏丂业丂丑丒专且丕世丗丘丙丐丂丌丂乄乕乔乙乭乏乄久乌丂业乛丂义乄丂业丂且专丘丂丌丂乔义乔乌久丂业丂\u0084⠳᩸丂丌丂乎乁乍久丂业丂\u0084⠳᩸丂丌丂乃乏乄久丂业丂丐专专乁丂九丌丂乌乏乇义乎乮乁乍久丂业丂乙乁与乌义丂丌丂乏乐久乒乁乔乏乒乳乔乁乔乕乓丂业丂丒丂丌丂久乎乁乂乌久乄丂业丂丐丂丌丂乄久乐乁乒乔乍久乎乔买乁乔么丂业丂丒丐丐丐丑专丑专乼乕丐丐专久丒丐丐丐丑专丒且乼乕丐丐专久丒丐丐丐丑且丘且乼乕丐丐专久丒丐丐丐且专且丑乼乕丐丐专久丒丐丐丐专丙世丙乼乕丐丐专久丒丐丐丐专丙丗专乼乕丐丐专久丂丌丂乊乏乂丂业丂丐专专乁丂丌丂乃乏乄久丂业丂丑丐丐丐丒丒世丗丂丌丂乄久乐乔乡乬乬乮乁乍久丂业丂*⍗ⱞ?ㅱǁ\u2E4F㟱Ⲡ캁Ý⤩?Ὄᷘ不쇰쨅\n" +
//                "ᇣ不ლ⥰«:?不?ᬎ칬컝?不ლ⥰쳯㢶ᴚ不ᵷ\u008Cლ⥰?不丂丌丂久乍乁义乌丂业丂乙乁与乌义习乃么义乎乁与乚么乁乏乇乁乎乇与乃乏乍丂丌丂乓久乘丂业丂丑丂丌丂乏乐久乒乁乔乏乒乮乏丂业丂丒丐丑丕丐且丒丗丐丑丒丘丗丂丌丂乌久乁乄久乒丂业乛丂乄久乐乔乮乁乍久丂业丂ᵷ\u008Cლ⥰?丂丌丂久乎乔乒乙乷乏乒之乄乁乙丂业丂丒丐丑专不丐丘不丑丒丂丌丂义乄乥乎乔义乔乙乮乏丂业丂丑丒专且丕世丗丘丙丐丂丌丂乄乕乔乙乭乏乄久乌丂业乛丂义乄丂业丂世丐专丂丌丂乔义乔乌久丂业丂ᴚ᧿ワ㨦丂丌丂乎乁乍久丂业丂ᴚ᧿ワ㨦丂丌丂乃乏乄久丂业丂丒丒丒丂九丌丂乌乏乇义乎乮乁乍久丂业丂乌义乍久乎乇乍久乎乇丂丌丂乏乐久乒乁乔乏乒乳乔乁乔乕乓丂业丂丑丂丌丂久乎乁乂乌久乄丂业丂丐丂丌丂乄久乐乁乒乔乍久乎乔买乁乔么丂业丂丒丐丐丐丑专丑专乼乕丐丐专久丒丐丐丐丑专丒且乼乕丐丐专久丒丐丐丐丑且丘且乼乕丐丐专久丒丐丐丐且专且丑乼乕丐丐专久丒丐丐丐专丙世丙乼乕丐丐专久丒丐丐丐专丙丗专乼乕丐丐专久丂丌丂乊乏乂丂业丂丒丒丒丂丌丂乃乏乄久丂业丂丒丐世丂丌丂乄久乐乔乡乬乬乮乁乍久丂业丂*⍗ⱞ?ㅱǁ\u2E4F㟱Ⲡ캁Ý⤩?Ὄᷘ不쇰쨅\n" +
//                "ᇣ不ლ⥰«:?不?ᬎ칬컝?不ლ⥰쳯㢶ᴚ不ᵷ\u008Cლ⥰?不丂丌丂久乍乁义乌丂业丂乌乍乍习乃么义乎乁与乚么乁乏乇乁乎乇与乃乏乍丂丌丂乓久乘丂业丂丑丂丌丂乏乐久乒乁乔乏乒乮乏丂业丂丒丐丑专丐丘丑丒丐丐丑且丑丂丌丂乄久乐乔乩乤丂业丂丒丐丐丐专丙丗专丂丌丂乏乐久乒乁乔乏乒乩乤丂业丂丑丕世丂丌丂乃乏乍乐丂业丂*⍗ⱞ?ㅱǁ\u2E4F㟱Ⲡ캁Ý⤩?Ὄᷘ丂丌丂乄久乐乔乡乌乌丂业丂丒丐丐丐丑专丑专乼乕丐丐专久丒丐丐丐丑专丒且乼乕丐丐专久丒丐丐丐丑且丘且乼乕丐丐专久丒丐丐丐且专且丑乼乕丐丐专久丒丐丐丐专丙世丙乼乕丐丐专久丒丐丐丐专丙丗专乼乕丐丐专久丂丌丂乁乒久乁乮乁乍久丂业丂ᵷ\u008C丂丌丂乏乐久乒乁乔乏乒乮乁乍久丂业丂⥮쪹쪹丂丌丂乄久乐乁乒乔乍久乎乔乩乄丂业丂丒丐丐丐专丙丗专丂丌丂乌久乁乄久乒乩乄丂业丂丒丐丑丒丑丒丑丒丐丐丐世专丂丌丂乄久乐乁乒乔乍久乎乔乣乏乄久丂业丂丑丐专丑丐丒丘丐丘丐丒丂九丌丂乄久乐乔乩乤丂业丂丒丐丐丐专丙丗专丂丌丂乏乐久乒乁乔乏乒乩乤丂业丂丑丐丐丕丂丌丂乃乏乍乐丂业丂*⍗ⱞ?ㅱǁ\u2E4F㟱Ⲡ캁Ý⤩?Ὄᷘ丂丌丂乄久乐乔乡乌乌丂业丂丒丐丐丐丑专丑专乼乕丐丐专久丒丐丐丐丑专丒且乼乕丐丐专久丒丐丐丐丑且丘且乼乕丐丐专久丒丐丐丐且专且丑乼乕丐丐专久丒丐丐丐专丙世丙乼乕丐丐专久丒丐丐丐专丙丗专乼乕丐丐专久丂丌丂乁乒久乁乮乁乍久丂业丂ᵷ\u008C丂丌丂乏乐久乒乁乔乏乒乮乁乍久丂业丂⥮º丂丌丂久乎乄乷乏乒之乄乁乙丂业丂丒丐丑丘不丐专不丐丕丂丌丂乄久乐乁乒乔乍久乎乔乩乄丂业丂丒丐丐丐专丙丗专丂丌丂乌久乁乄久乒乩乄丂业丂丒丐丑专丐丘丑丒丐丐丑且丑丂丌丂乄久乐乁乒乔乍久乎乔乣乏乄久丂业丂丑丐专丑丐丒丘丐丘丐丒丂九丌丂乭久乓乓乁乇久丂业乛丂乭久乓乓乁乇久乣乏乄久丂业丂丑丂九九";
//        // 获取用户输入
//        char[] array = url.toCharArray();
//        // 获取字符数组
//        for (int i = 0; i < array.length; i++) {// 遍历字符数组
//            array[i] = (char) (array[i] ^ 20000);// 对每个数组元素进行异或运算
//        }
//        System.out.println("加密或解密结果如下：");
//        System.err.println(new String(array));// 输出密钥
//    }


    private static JSONObject getDataFromJqkaCache(String key) throws Exception {
        //创建一个httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpClient httpClient = new DefaultHttpClient();

        // 设置超时时间
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

        String url = "http://乃乒乍与乐乕乒乃么乁乓久与乚么乁乏乇乁乎乇乒久乎乕乁乔与乃乏乍/companyManage/doQuery";
        HttpPost post = new HttpPost(url);
        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");
        post.setHeader("Cookie", "zg_sso_token=sspnJq4-z5c6nie6-lUNG7vnvmnzr4S1PcjNbR4pHr9PsyJSAcnxOawH4Qauwi7hWkCRJVbS7uc.; portalCookie=EgN_9fwUf1X9Mkg27WNRpyOg5Lmap3FkxRkDCY22etStCwxWSWZcfzZ4aorKxkNv; route=80c1eb32de8c008f40c7cd92f7f58d4c; gr_user_id=fcf76ad9-6471-481a-a4a4-e301cd841c7a; gr_session_id_bfb72280076c619b=8f218250-a42b-4da1-8d86-37f7971b5460; gr_session_id_bfb72280076c619b_8f218250-a42b-4da1-8d86-37f7971b5460=true\n" +
                "Host: 乃乒乍与乐乕乒乃么乁乓久与乚么乁乏乇乁乎乇乒久乎乕乁乔与乃乏乍");
        post.setHeader("Origin", "http://乃乒乍与乐乕乒乃么乁乓久与乚么乁乏乇乁乎乇乒久乎乕乁乔与乃乏乍");
        post.setHeader("Referer", "http://乃乒乍与乐乕乒乃么乁乓久与乚么乁乏乇乁乎乇乒久乎乕乁乔与乃乏乍/companyManage/index");
        post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");

        // 构建消息实体
        String json1 = "{addedEndDate:\"\",addedStartDate:\"\",city:\"-1\",companyAuthentication:\"-1\",companyCodeAndName:\"" + key + "\",customerTag:\"-1\",hasPrivilege:\"-1\",ifHasMailAddress:\"-1\",invoiceStatus:\"-1\",pageNumber:1,pageSize:10,province:\"-1\",sortName:\"A.ADDED_TIME\",sortOrder:\"desc\",status:\"T\"}";

        System.out.println(json1);
        StringEntity entity = new StringEntity(json1, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);

        HttpResponse response = httpClient.execute(post);

        //取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity2 = response.getEntity();
        String string = EntityUtils.toString(entity2, "utf-8");
        JSONObject jsonObject = JSON.parseObject(string);

        String companyCode = (String) ((JSONObject) ((JSONArray) ((JSONObject) jsonObject.get("data")).get("rows")).get(0)).get("companyCode");
        companyCode = companyCode.replace("C", "");
//        String sst = "{\"companyId\":[\""+companyCode+"\"],\"custOpType\":100}";

        String file = "src/main/resources/data/bak009.txt";
        FileUtils.fileChaseFW(file, companyCode, true);


        System.out.println(companyCode);

//        response.close();
//        httpClient.close();

        return jsonObject;
    }
}
