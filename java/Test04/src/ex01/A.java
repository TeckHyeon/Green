package ex01;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class A {

   public static void main(String[] args) {
      // 문자열 조작 함수
      //              0123456 7 8 9012
      String  s1   = "Hello 李순신 123";    
      String  s1_2 = "Hello 李순신 123";
      System.out.println( s1 == s1_2);          // true s1 == s1_2, 위치비교
      System.out.println( s1.equals(s1_2)  );   // true 글자값비교
      //                         0 1 2 3 4 56789012      
      String  s2   = new String("안녕하세요 Mark 42"); 
      String  s2_2 = new String("안녕하세요 Mark 42"); 
      System.out.println(s2 == s2_2 );			// false s2 != s2_2 , 위치비교
      System.out.println( s2.equals(s2_2) );	// true, 글자값 비교
      System.out.println( s1 );
      System.out.println( s2 );
      
      // 문자열길이(글자수) - 유니코드문자의 갯수
      int  len1  = s1.length();   // 함수  s1.length()  // 13
      System.out.println( len1 );
            
      int  len2 = s2.length();  // 13
      System.out.println( len2 );
      
      // 문자열 byte 수 구하기
      // byte[] b = s1.getBytes();  // 문자열을 byte[] 배열로 변환
      int  lenb1 = s1.getBytes().length;  //  length : 배열의 길이, 19
      System.out.println( lenb1 );
      int  lenb2 = s2.getBytes().length;  //  length : 배열의 길이, 23
      System.out.println( lenb2 );
      
      
      // 특정위치의 문자열을 추출 : 6~8
      String  name = s1.substring(6, 8+1);   // 李순신
      System.out.println(name); 
      
      // 문자열비교 ( ==  비교하면 안됨)
      String  s3 = "이순신";
      String  s4 = "이이";
             
      boolean  isSame = s3.equals(s4); // 문자열 data 비교
      System.out.println( isSame );    // false
      
      int      eq     = s3.compareTo( s4 ); //  위치결정
      System.out.println( eq );       // -1368 : 앞문자가 작은 code
      // eq > 0   : 큰글자 사전순서가 뒤로간다
      // eq == 0  : 같은글자 
      // eq < 0   : 작은글자 사전순서상 앞이다
      //  "ABC1".compareTo("ABA")   //   "ABC1"
                                    // - "ABA"
                                    //  2 
      
      String   s5    =  "Test123";
      String   s6    =  "TEST123";
      
      System.out.println( s5.equals(s6) );     // false
      System.out.println( s5.compareTo(s6) );  // 32 - 대소문자 차이
      // 대소문자 무시하고 비교
      System.out.println( s5.compareToIgnoreCase(s6) );  // 0 -> 같다
      
      // 문자열을 모두 대문자로 변경
      System.out.println(  s5.toUpperCase()   );
      
      // 문자열을 모두 소문자로 변경
      System.out.println(  s5.toLowerCase()   );
      
      // 문자열 결합
      String   s7   =  s5 + "," + s6;
      System.out.println( s7 );
      String   s8   =  s7.concat("|").concat("Hello");
      System.out.println( s8 );
      
      //-----------------------------------
      // 문자열 조작 - 속도를 빠르게 한다 : String보다 빠름
      // 1.6 이전의 상황
      StringBuilder   sb =  new  StringBuilder();  // String sb
      sb.append( s8 );            // sb = sb + s8; // sb = sb+ s8
      sb.append("---------------");				   // sb = sb + "------------"
      sb.append( s8 );							   // sb = sb + s8;
      
   //   System.out.println( sb.toString() ) ;
      System.out.println( sb ) ;
      
      // StringBuilder : thread 사용금지
      // StringBuffer  : thread safe 버전
      
      //--------------------------------------------
      // 문자찾기
      //               0123456 7 8 9012
      // String  s1 = "Hello 李순신 123";
      //                          0 1 2 3 4 56789012
      // String  s2 = new String("안녕하세요 Mark 42"); 
            
      // 특정 위치의 문자
      char  ch1 = s1.charAt( 6 );
      System.out.println( ch1 ); // 李
      
      // 툭정 문자의 위치 (0~)
      int  pos1 = s1.indexOf('l');   // -1 : 못찾음   
      System.out.println( pos1 );    // 2 : 첫번째의 'l' 위치
      int  pos2 = s1.indexOf('l', pos1+1); // 2+1 : 2 다음 부터
      System.out.println( pos2 );    // 3 : 두번째의 'l' 위치

      // s1 에 있는 모든 'l' 의 위치를 출력
      //               0123456789012345678901
      String   str1 = "Hello Hello Hello love";
      for (int i = 0; i < str1.length(); i++) {
         if(   str1.charAt(i) == 'l' )
            System.out.print( i + " " );
      }  // 2 3 8 9 14 15 18 
      System.out.println( );
      
      int  p = -1;
      do {
         p = str1.indexOf("l", p+1);
         if(p > -1) System.out.print (p + " ");
      } while( p != -1 );
      System.out.println(); 
      
      System.out.println( s2.indexOf("Mark") ); // 6 문자열 검색가능
      
      // 문자열을 뒤에서 부터 찾기
      System.out.println(  str1.lastIndexOf('l') );  // 18
      
      // 문자열 찾기
      //               0123456 7 8 9012
      // String  s1 = "Hello 李순신 123";              
      // String  s2 = new String("안녕하세요 Mark 42"); 
      System.out.println("== 문자열 찾기===");
      System.out.println( s1.contains("순신") );             // true , 일부일치
      System.out.println( s1.equals("순신이") );             // false, 완전일치 String
      System.out.println( s1.contentEquals("순신이") );      // false, 완전일치 String, StringBuilder
      System.out.println( s1.contentEquals("Hello 李순신 123") );  // true
      
      System.out.println("=========================");
      // isEmpty()
      String  sa1 = "abcdef";
      String  sa2 = "";
      System.out.println( sa1.isEmpty() );   // false -> 비문자열인가 ""
      System.out.println( sa1.equals("") );  // false
      System.out.println( sa2.isEmpty() );   // true
      System.out.println( sa2.equals("") );  // true
      String  sa3 = null;
      if(sa3 == null)
         System.out.println("null 입니다");
      else
         System.out.println( sa3.indexOf('a') ); // java.lang.NullPointerException
      
      //============================
      // 문자열을 숫자로 변환
      // 정수
      String    sv1 =  "124";
      
      int [] arr1 = new int[5];; //int 배열 5개 짜리
      // 배열 - 실행할 때 사이즈가 변하지 않는다.
      ArrayList<Integer> all = new ArrayList<Integer>();
      // List - 실행할 때 배열의 크기가 변경된다.
      
      // int      : value type      Primitive type(기본형)
      // Integer  : reference type  int 의 Wrapper Class 
      // double  -> Double
      // byte    -> Byte
      
      int       v1  =  Integer.parseInt( sv1 );
      Integer   v2  =  Integer.valueOf(  sv1 );
      System.out.println( v1 );
      System.out.println( v2.toString() ); // .toString() 생략가능
      System.out.println( v2            ); // .toString() 생략가능
      
      // 실수
      String    sw1 = "124.567";
      
      double    w1  = Double.parseDouble( sw1 ); // 124.567
      Double    w2  = Double.valueOf( sw1 );
      double    w3  = Double.valueOf( sw1 ); // 자동형변환 implicit  vs  수동형변환 explicit
      System.out.println( w1 );
      System.out.println( w2.toString() );
      System.out.println( w3 );
      
      //  숫자 -> 문자 String.valueOf() : 중요
      int      num1   =  123;
      String   snum1  =  num1 + "";
      String   snum2  =  String.valueOf( num1 );   
      
      double   num2   =  123.456;
      String   snum3  =  String.valueOf( num2 ); 
            
      //                      0123456789
      // 문자 베열 -> 문자열  Hello Java
      //byte []  bytes      =  new bytes[]  {'H', 'e', 'l', 'l', 'o', ' ', 'J', 'a', 'v', 'a' };
      byte []  bytes      =  {'H', 'e', 'l', 'l', 'o', ' ', 'J', 'a', 'v', 'a' };
      String   strbytes   =  new String ( bytes );   // String <- byte[]
      System.out.println( bytes );      // [B@36aa7bc2 :배열의 hashcode (메모리 위치 16진수)
      System.out.println( Arrays.toString( bytes ));
      System.out.println( strbytes );                
      System.out.println( strbytes.toString() );  // "Hello Java"
      
      String   strbytes2 = new String( bytes, 6, 4 );
      System.out.println(  strbytes2 );  // 'Java'
      
      // replace : 문자열 바꾸기
      String    sc1  =  "Test123Test한글 영어 한글test";
      String    sc2  =  sc1.replace("Test", "Example");
      System.out.println( sc1 );
      System.out.println( sc2 );
      
      // 공백제거 : 앞뒤의 공백 제거
      String   sd1 = "       Text   Editor  v1.0        ";
      System.out.println( sd1 );
      System.out.println( sd1.trim() );
      System.out.println( sd1.length() );           // 34 
      System.out.println( sd1.trim().length() );    // 19
      
      // 문자열 일부 추출
      //               01234567890123
      String  jumin = "970508-2111020";
      System.out.print(jumin.substring(0, 2) + " ");   // "97"
      System.out.print(jumin.substring(2, 4) + " ");   // "05"
      System.out.print(jumin.substring(4, 6) + " ");   // "08"
      System.out.print(jumin.substring(7, 8) + " ");   // "2"
      
      int year       = Integer.parseInt("19" + jumin.substring(0, 2));
      int month      = Integer.parseInt(jumin.substring(2, 4));
      int dayOfMonth = Integer.parseInt(jumin.substring(4, 6));
      
      // 날짜 가져오는 기능
      LocalDateTime bDate 
         = LocalDateTime.of(year, month, dayOfMonth, 0, 0);
      System.out.println("\n생일:" + bDate);
      
      DateTimeFormatter  fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      System.out.println("\n생일:" + bDate.format(fmt) );
      
      String  dayOfWeek      = bDate.getDayOfWeek().toString(); // MONDAY
      int  dayOfWeekValue    = bDate.getDayOfWeek().getValue(); // 1(월)~7(일)
      //                   0    1    2    3    4    5    6    7    
      String [] weekDay = {"", "월","화","수","목","금","토","일"}; 
      System.out.println("\n요일:" + weekDay[dayOfWeekValue] + "요일");
      System.out.println("\n요일:" + dayOfWeek               + "요일");
      
      //----------------------------------------------
      int  sex = Integer.parseInt( jumin.substring(7, 8) );
      if (sex % 2 == 1) 
         System.out.println("남자");
      else
         System.out.println("여자");
      
      System.out.println();
      
      //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      System.out.println("====================*============================");
      int ch = 65;
      System.out.printf("%c %d\n", ch, ch); // A 65
      
      // leading 0 : 12 -> "00012"
      // format  %d : decimal 10진 정수
      //         %x : hexa decimal 16진 정수
      //         %f : 실수 float, double
      //         %c : char
      //         %s : string
      //         %5d  전체 5자리수             100  : 100__  뒷쪽 공배 추가
      //         %-5d 전체 5자리수             100  : __100  앞쪽 공백 추가
      //         %05d                          100  : 00100
      //         %.3f 소수이하 3자리로 반올림  12.34567 : 12.346
      
      long l = Math.round(12.34567); // 정수만 반올림한다
      System.out.println("l="+l);
      String result1 = String.format("%.3f\n", 12.34567);
      System.out.println(result1);
      int      num3      =  12;
      String   snum3_2   =  String.format("%05d", num3);
      System.out.println(  snum3_2 );
       
      // 세자리마다 ,  출력
      // # : 숫자, 공백
      // 0 : 숫자, 0
      DecimalFormat  df      =  new DecimalFormat("#,###,##0.00"); // # = 앞 자리가 0이면 안 찍음
      DecimalFormat  df2     =  new DecimalFormat("0,000,000.00"); //
      double         price1  =  12345678.789543;
      System.out.println( "df="+df.format(price1) );     // 12,345,678.79
      System.out.println( "df2="+df2.format(123) );       // 0,000,123.00
      System.out.println( "df0="+df.format(0) );          // 0.00
     
      double        price2  = 123456789.56789;    
      System.out.println( df.format(price2) );     // 123,456,789.57
      System.out.println( df2.format(12.3456) );   // 0,000,012.35
      
       //---------------------------------
      // ~  로 시작하는
      String    name1 = "유재석";
      System.out.println( name1.startsWith("김") );  // 김~
      System.out.println( name1.contains("유") );  // ~유~ 그냥 '유'라는 글자를 포함하면 true
      System.out.println( name1.endsWith("신") );    // ~신
      
      String   []  names = new String [] {
         "김유신", "이유신", "박유신", "최유신", "김순신",
         "홍길동", "전우치", "김장군", "이장군", "박대장", 
         "유관순", "아이유", "제갈유지"
      };
      
      //  "김" 으로 시작되는
      for (int i = 0; i < names.length; i++) {
         if(  names[i].startsWith("김")  )
            System.out.print( names[i] + " ");
      }
      System.out.println();
      //  "유" 를 포함하는
      for (int i = 0; i < names.length; i++) {
         if(  names[i].contains("유")  )
            System.out.print( names[i] + " ");
      }
      System.out.println();
      
      // 중간에 "유"가 있는 이름 출력 
      // 1.
      for (int i = 0; i < names.length; i++) {
         if( names[i].indexOf("유") == 1 ) 
            System.out.print( names[i] + " " );
      }
      System.out.println();
      
      // 2.
      for (int i = 0; i < names.length; i++) {
         int idx     = names[i].indexOf("유");
         int lastIdx = names[i].length() - 1;
         if( idx > 0 && idx != lastIdx ) 
            System.out.print( names[i] + " ");
         /*
         if (idx == -1)  // "유"글자없음
         if( idx == 0 )  // "유" 가 첫글자
         if( idx == names[i].length()-1 ) // 마지막 글자가 "유"
         */   
         
      }
      System.out.println();
      
      //-----------------------------------
      // 정규식(Regular Expression)
      // 010 이나(또는 | ) 051 로 시작하고 중간에 - 사용
      // 국번은 숫자(\d) 3자리 또는 4자리 ({3,4}) 이어야 하고
      // 번호는 숫자 4자리임
      // 한자리([])의 숫자 [0123456789]
      // 한자리([])의 숫자 [0-9] : - 범위 (0~9)
      // 01[016789]
   
      
      String   regExp  =  "(051|010)-\\d{3,4}-\\d{4}";
      String   data    =  "010-3121a-1234";
      boolean  result  =  Pattern.matches(regExp, data);
      if(result)
         System.out.println("정확한 전화번호 입력");
      else
         System.out.println("전화번호 잘못 입력하셨습니다");
      
      // 이메일 정규식 \w : 영숫자,  + : 한글자 이상
      regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; // 이메일주소
      data   = "angel@navercom";
      result = Pattern.matches(regExp, data);
      if(result)
         System.out.println("정규식과 일치합니다");
      else
         System.out.println("정규식과 일치하지 않습니다");
      
      // 아이디 (자리수 8-12, 특수문자x)
      regExp = "^[a-z]{1}[a-z0-9]{7,12}+$"; 
      data   = "abcd1234";
      result = Pattern.matches(regExp, data);
      if(result)
         System.out.println("정규식과 일치합니다");
      else
         System.out.println("정규식과 일치하지 않습니다");
      // 이메일주소
      // 암호(자리수 8-12, 영문자, 숫자, 대문자하나이상, 특수문자1개이상 )
      
      // 전화번호, 휴대폰번호
      
      // 주민등록번호, 사업자등록번호
      
      // 이메일 주소
   }

   /*
    * 
    * https://namu.wiki/w/%EC%A0%95%EA%B7%9C%20%ED%91%9C%ED%98%84%EC%8B%9D?from=%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D

   正規表現式 / regular expression

   프로그래밍에서 문자열을 다룰 때, 문자열의 일정한 패턴을 표현하는 일종의 형식 언어를 말한다. 정규식이라고도 부르며,보통 regex 혹은 regexp라 많이 쓴다.
   2. 설명[편집]
   프로그램을 작성할 때는 특성상 일정한 규칙을 가진 텍스트 문자열을 사용하는 경우가 많은데, 이럴 때 정규 표현식을 사용한다. 특히 컴파일러의 파서 부분은 이 정규표현식이 반드시 들어간다. 유닉스 계열 운영체제에서 CLI 환경을 주로 사용하는 경우 grep, sed, awk 등으로 인해 거의 필수적으로 알게 될 수밖에 없는 언어.[1]

   잘 알아두면 문자열을 다루는 데 대단히 유용하기 때문에 C를 비롯한 여러 프로그래밍 언어에서 이 정규 표현식을 지원한다. 특히 웹 프로그래밍은 문자열을 다루는 빈도가 특히 높기 때문에 사용하는게 거의 필수적. 예를 들면 위키위키만 해도 DB에 저장된 텍스트에 있는 위키 문법을 엔진에서 해석해서 출력해주는 작업이 필요한데, 위키 문법도 일정한 규칙이 있는 문자열이니만큼 이 작업에서 정규표현식은 반드시 들어간다.

   그냥 읽기에는 상당히 난해한데, 문법이 일반적인 프로그래밍 언어의 형식과는 판이하게 다른데다 한 눈에 알아보기 어렵게 되어 있다. 정규표현식 중간에 주석을 허용하지 않는 경우에는 강제개행 없이 한 줄에 주르르륵 쓰게 되는데, 조금만 복잡해지면 각종 특수문자가 마구마구 튀어나오기 때문에 무슨 외계어처럼 느껴진다. 이 때문에 초보 프로그래머는 가급적 이 물건에 손을 안 대려고 하는 경향이 많은데, 정규식을 안 쓸 경우 문자열 처리 코드 자체가 대단히 복잡해진다. 그렇게 복잡하게 문자열을 처리할 바에, 정규식 배우는게 여러모로 낫다. 사실 정규식이 복잡한 것은 확실한 단점이기 때문에 문자열 처리 함수를 다양하게 제공하는 언어도 있지만, 문자열이라는 것이 항상 고정된 형식으로 나오는 것이 아니기 때문에 정규식을 안 쓸래야 안 쓸수가 없다. 가끔씩 정작 자신이 작성했다가 시간 지나면 이게 뭔 말인지... 하게 된다.

   정규 표현식은 언어마다 문법이 조금씩 다른데, 쉘에서 주로 정규표현식을 사용하는 사용자 입장에서는 이것이 문제가 되는경우도 종종 있다. 크게 나누면 표준으로 인정된 POSIX의 정규 표현식과 그것에서 문법을 매우 확장한 Perl 방식의 PCRE[2] 이 둘로 나뉘어지며, POSIX 표준의 경우 다시 Basic 과 Extended 로 나뉜다. 이외에도 Emacs와 Vim 모두 자체적인 정규표현식을 지원한다. 문제는, 이 정규표현식들이 완전히 다르면 모르겠지만, 비슷하면서도 살짝살짝 다르기 때문에 그 차이들을 다 외우고 있을 수도 없는 노릇이며, 정규표현식 자체가 다량의 텍스트를 다루는 명령이니만큼 작은 실수가 커다란 차이를 불러올 수 있다는 점이다. 즉, 셸에서 쓰기 작업에 정규표현식을 동반할 경우 매우 주의를 요할 필요가 있다. 또 다른 문제는, 자신이 뭘 원한다고 해서 그것만 배우고 쓰면 되는 게 아니라 프로그램마다 지원하는 정규표현식이 다르기 때문에 그에 맞춰 배우고 써줘야 한다.[3] PCRE의 경우 이미 정규표현식이라고 부를 수 없을 정도로 기능이 확장되어 있는데[4], 덕분에 이런 이상한 짓도 가능하다. (...)

   3. 문법[편집]
   자바스크립트의 문자열에서 URL을 찾는 정규표현식의 예제는 다음과 같다.

   /(http|https|ftp|telnet|news|mms):\/\/[^\"'\s()]+/i

   위 정규식은 아래와 같이 구분이 된다.
   /
   (http|https|ftp|telnet|news|mms):\/\/[^\"'\s()]+
   /                 
   i
   패턴구분자 시작
   찾을 문자열의 패턴
   패턴구분자 끝
   패턴변경자
   
   3.1. 패턴구분자[편집]
   정규식의 패턴이 달라질 경우 그것을 구분하는 문자로, 정규식 패턴이 하나만 있을 경우에는 굳이 쓸 필요가 없지만 대부분 붙인다. 난해하게 만드는 주범이다. 왜냐하면, 이 패턴구분자는 특수문자 중 역슬래시(\)를 제외하고 아무거나 쓸 수 있기 때문이다. 심지어 아래 등장하는 의미를 가진 문자(메타 문자라고 부른다)도 패턴구분자로 쓸 수 있다. 보통 슬래시(/)를 많이 사용하지만 규칙이 있는 것이 아니라서 정말로 프로그래밍 하는 사람 마음대로다. 이래저래 헷갈리는 주범 중 하나.
   3.2. 메타 문자[편집]
   정규 표현식에서 일정한 의미를 가지고 쓰는 특수문자를 메타 문자라고 부른다. 이를 사용하는 이유는 평문으로 찾기 어려운 특정 패턴을 추출하기 위해서이다. 반대로 메타 문자가 아닌 문자들을 사용하면 평문으로 검색하는 것과 동일한 효과를 낸다. 목록은 다음과 같다.

   $ ( ) * + - . ? [ \ ] ^ { | }

   역 슬래시 문자는 다른 메타 문자들과 달리 조금 특수한 목적으로 사용되는데 메타 문자를 일반적인 문자로 인식하게 하여 검색에 사용할 수 있게 한다. 이 외에도 미리 정의된 목적을 위해 사용된다.

   ^: 문자열의 시작
   $: 문자열의 종료. 옵션에 따라 문장의 끝 또는 문서의 끝에 매치된다.
   .: 임의의 한 문자
   []: 문자 클래스. 문자 클래스 안에 들어가 있는 문자는 그 바깥에서 하나의 문자로 취급된다.
   ^: 문자 클래스 내에서 ^는 not
   -: ex) a-z는 a에서 z까지의 문자
   |: or를 나타냄
   ?: 앞 문자가 없거나 하나 있음, 0 | 1
   +: 앞 문자가 1개 이상임
   *: 앞 문자가 0개 이상임
   {n,m}: 앞 문자가 n개 이상 m개 이하. {0,1}은 ?와 같은 의미다.
   {n,}: 앞 문자가 n개 이상. 위의 형태에서 m이 생략된 형태이다. {0,}이면 *와 같고 {1,}이면 +와 같은 의미이다.
   {n}: 앞 문자가 정확히 n개. {n,n}과 같은 의미이다.
   (): 하나의 패턴구분자 안에 서브 패턴을 지정해서 사용할 경우 괄호로 묶어주는 방식을 사용한다.
   \s: 공백문자
   \b: 문자와 공백 사이를 의미한다.
   \d: 숫자에 해당하는 유니코드에 대응. [0-9]와 달리 아랍 문자, 페르시아 문자 등 다양한 숫자를 포괄한다.#
   \t: 탭문자
   \w: 단어 영문자+숫자+_(밑줄) [0-9a-zA-Z_]
   문자 이스케이프는 대문자로 적으면 반대를 의미한다.

   3.3. 패턴변경자[편집]
   패턴구분자가 끝나면 그 뒤에 쓰는 것으로, 패턴에 일괄적으로 변경을 가할 때 사용한다. 정규식 엔진에 따라 변경자의 적용 방식이 상이하므로 해당 구현의 매뉴얼을 읽어야 한다. 예를 들어 대소문자 무시 플래그의 경우
   자바스크립트는 /패턴/i 로 쓰지만 파이썬에서는 re.compile(패턴, flags=re.I) 로 Go에서는 (?i)패턴으로 쓴다.
   i: 패턴을 대소문자 구분 없이 검사한다. 이 변경자를 사용할 경우 [a-z]로만 검사해도 자동으로 [a-zA-Z]와 같은 기능을 하게 된다. 영어가 아닌 언어(독일어, 프랑스어 등)를 다룰 때에는 버그 가능성이 있으므로 쓰지 않는 게 좋다. 대소문자라는 개념이 없는 한글, 한자, 가나문자는 이 패턴 변경자가 아무 역할도 하지 않는다.
   s: 임의의 한 문자를 가리키는 . 메타 문자에 개행 문자(\n)도 포함시키도록 한다. 이 변경자를 사용하면 .이 줄바꿈도 임의의 한 문자로 취급하여 찾는다.
   g: ^문자가 문장이 아닌 문서의 처음에, $ 문자가 문장의 끝(라인 피드 \n)이 아닌 주어진 문자열의 끝에 매치되게 변경한다.
   m: 주어진 문자열에 줄바꿈이 있을 경우, 여러 줄로 취급하여 검사한다. (줄바꿈이 없다면 써도 의미가 없다.) 원래 정규표현식을 쓸 때 줄바꿈은 무시되는데, 이걸 사용하면 줄바꿈을 적용해서 검사한다. 그리고 ^은 한 줄의 시작, $는 한 줄의 끝으로 의미가 달라진다.
   x: 공백 문자를 무시한다. 단, 이스케이프(역슬래쉬하고 같이 쓸 경우)하거나 문자 클래스 안에 있을 경우에는 예외. 정규식을 조금 더 읽기 편하게 만들어준다. 그러나 이 변경자를 지원하지 않는 엔진이 많은 게 단점이다.

   3.4. 예제[편집]
   기본적인 정규식
   ^[0-9]*$: 숫자
   ^[a-zA-Z]*$: 영문자. 패턴변경자를 써서 /^[a-z]*$/i 같이 쓸 수 있다.
   ^[가-힣]*$: 현대 한글(유니코드를 지원하는 정규식 엔진에 한정)
   ^[ㄱ-ㅎㅏ-ㅣ가-힣]*$: 한글 자모 낱자를 포함한 모든 현대 한글
   굳이 유니코드 환경에서도 KS X 1001 완성형의 현대 한글 2350자만 선택하고 싶다면 완성형/한글 목록/KS X 1001 문서의 끝부분을 참고할 것.
   ^[a-zA-Z0-9]*$: 영문/숫자

   3.5. 탐욕적 및 게으른 수량자[편집]
   정규 표현식에서는 일치하는 패턴을 찾는 횟수 제한이 없어 필요 이상의 상황을 연출하기도 하는데 이것은 의도적으로 수량자를 탐욕적으로 만들었기 때문이다. 문법에서 말하는 탐욕적 수량자(Greedy Quantifier)란 가능하면 가장 큰 덩어리를 찾는다는 뜻이다. 반대의 개념인 게으른 수량자(Lazy Quantifier)는 패턴에 근접하는 최소한의 덩어리를 찾는다.
   탐욕적 수량자: *, +, {n,}
   게으른 수량자: *?, +?, {n,}?

   사용 예(Python) :

   >>> data = "<div> <p>First</p> <p>Second</p></div>"
   >>> import re
   >>> re.findall(r"<p>(.+)</p>", data)  # 기본적으로 탐욕적인 매칭
   ['First</p> <p>Second']
   >>> re.findall(r"<p>(.+?)</p>", data)  # 게으른 수량자 사용
   ['First', 'Second']

   사실 제대로 구현한 HTML 파서(Parser)는 정규식에 유한상태기계를 결합한 오토마타를 사용하지 게으른 수량자를 사용하지 않는다. 물론 언어별로 HTML 파서는 거의 만들어져 있으므로 HTML 파서를 또 구현할 필요는 전혀 없다.

   그리고 수량자를 사용해도 정규식으로는 괄호 매치를 못 한다. 무슨 얘기냐면, 지금 매치한 닫힌 괄호에 대응하는 열린 괄호를 찾는 문제는 정규식만으로는 안 된다. 고정 갯수의 괄호는 매치할 수 있지만 임의의 괄호는 매치할 수 없다. 이는 정규식이 정규 언어이기 때문에 발생하는 한계이다.[5] 괄호 매치를 하려면 최소 푸시다운 오토마타(문맥 자유 언어)가 필요하다.

   4. 학습 관련 사이트[편집]
   regexone
   step-by-step 방식으로 빠르게 배울 수 있는 사이트.
   regex101
   간편하게 정규식을 연습하고 디버깅할 수 있는 사이트. 여러 색상으로 그룹을 표시해주기 때문에 구분이 원활하다.
   PCRE, 자바스크립트, 파이썬, Go를 지원한다.
   regexr
   PCRE, 자바스크립트를 지원한다.
   regexper, debuggex, extendsclass
   정규식을 시각화해주는 사이트. 작성한 정규식을 유한 오토마타로 변환하여 보여준다. 남이 만든 정규식이 도저히 읽히질 않으면 여기에 그 코드를 복붙해보자. regexper.com은 정규식을 그림 파일로 다운로드하는 기능을 제공하고 debuggex.com은 실시간 정규식 시각화 및 매치 테스트를 제공한다.
   Mozilla JavaScript RegExp Guide
   모질라 재단에서 제공하는 개발자 문서로 자바스크립트의 정규 표현식 문법에 대해서 설명한다.

   프로그래밍 언어에서 배우고 싶으면 자바스크립트의 정규식 엔진[6]을, 쉽게 배우고 싶으면 Ruby를 추천한다. 원조는 Perl이지만 언어의 문법 자체가 괴랄하므로 펄 언어 자체를 공부하는 부담이 Ruby보다 크기 때문이다.

   Webhacking.kr에서 정규표현식을 다루는 문제가 하나 있다.

   5. 주의점[편집]
   보통 일반적인 언어에서 지원하는 정규식 엔진은 백트랙킹을 일치 여부를 판단하도록 구현되어 있다. 이유는 유한 오토마타보다 구현하기 쉽고, 또 역참조(back reference) 같은 편리한 기능을 지원하기 때문이다.

   그러나 백트랙 특성상 최악의 경우 O(2^n)O(2n)의 시간 복잡도를 가지므로
    문제가 발생할 여지가 있는데, 이런 취약점을 공격하는 방식을 ReDos(regular expression denial of service)라고 한다.[7]

   고의든 아니든간에 ReDos 공격을 받으면 서버 자원이 고갈되게 되며, 이는 서비스 장애로 이어질 수 있으므로, 작성한 정규식을 프로덕션에 반영하기 전에 반드시 정규식 테스트 사이트에서 다양한 케이스를 통해 검증하도록 하자.

   6. 기타[편집]
   어감 때문에 규식이라고 부르는 사람도 존재한다.[8]

    */
}







