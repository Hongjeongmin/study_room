import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class programmers_lv2_오픈채팅방 {

	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = {};
        Map<String, String> nicknameMap = new HashMap<>();
        List<String> answerList = new ArrayList<>();
        int resultCnt = 0;

        for(int i = 0; i < record.length; i++) {
            StringTokenizer str = new StringTokenizer(record[i]);
            String command = str.nextToken();
            String uid = str.nextToken();
            String nickname = "";
            if(!command.equals("Leave")) {
                nickname = str.nextToken();
                nicknameMap.put(uid, nickname);
            }
        }

        // for(String key : nicknameMap.keySet()) {
        //     System.out.println(nicknameMap.get(key));
        // }

        for(int i = 0; i < record.length; i++) {
            StringTokenizer str = new StringTokenizer(record[i]);
            String command = str.nextToken();
            String uid = str.nextToken();
            if(!command.equals("Change")) {
                if(command.equals("Enter")) {
                    answerList.add(nicknameMap.get(uid) + "님이 들어왔습니다.");
                } else {
                    answerList.add(nicknameMap.get(uid) + "님이 나갔습니다.");
                }
            }
        }
        int arrListSize = answerList.size();
        answer = answerList.toArray(new String[arrListSize]);

//        return answer;
		
	}
	
}
