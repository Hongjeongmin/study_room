import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_lv2_문자열압축 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int answer = 0;
        
        List<String>list = new ArrayList<>();
        List<Integer>lengthList = new ArrayList<>();
        
        if(s.length() == 1) {
            answer = 1;

        } else {
            for(int i = 1 ; i <= s.length() / 2; i++) {
            String identifier = s.substring(0,i);
            int count = 1;
            for(int j = 1; j < s.length() / i; j++) {
                if(identifier.equals(s.substring(i*j, i*j + i))) {
                    count++;
                    if(j+1 >= s.length() / i ) {
                        list.add(count + "");
                        list.add(identifier);
                        count = 1;
                        identifier = "";
                    }
                } else {
                    list.add(count + "");
                    list.add(identifier);
                    count = 1;
                    identifier = s.substring(i*j, i*j + i);
                    
                    if(j+1 >= s.length() / i ) {
                        list.add(identifier);
                        identifier = "";
                    }
                    
                    continue;
                }     
            }
            
            if(s.length() % i != 0) {
                list.add(s.substring( ( s.length() / i ) * i, s.length()));
            }
            
            String tmp = "";
            for(int j = 0; j < list.size(); j++) {
                if(!list.get(j).equals(1 + "")) {
                    tmp+=list.get(j);
                }
            }
            list.clear();
            lengthList.add(tmp.length());
        }
        
        Collections.sort(lengthList);
            answer = lengthList.get(0);
        }
        
        System.out.println(answer);
//        return answer;
	}
	
}
