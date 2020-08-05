package level2.오픈채팅방;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        Solution solution = new Solution();

        System.out.println(
            Arrays.toString(solution.solution(record))
        );
    }

    public String[] solution(String[] records) {
        List<History>   histories = new ArrayList<>(records.length);

        for (String record : records) {
            histories.add(process(record));
        }

        return new String[] {""};
    }

    private History process(String record) {
        String[] commands = record.split(" ");
        String behavior = commands[0];
        String uuid     = commands[1];
        String nickname = "";

        if(commands.length > 2) {
            nickname = commands[2];
        }

        User user = new User(uuid, nickname);
        switch (behavior) {
            case "Enter":
                user.enterUser( user);
                break;
            case "Leave":
                break;
            case "Change":
                user.changeUserName(user, nickname);
                break;
        }
        return new History(behavior, user);
    }
}
class History {
    String command;
    String syntax;
    User   user;

    public History(String command, User user) {
        this.command = command;
        this.user = user;

        if("Enter".equals(command)) {
            this.syntax = "들어왔습니다.";
        } else if("Leave".equals(command)) {
            this.syntax = "나갔습니다.";
        }
    }

    public String getLog() {
        return String.format("%s님이 %s", user.getNickname(), syntax);
    }
}
class User {
    static Map<String, String> userMap = new HashMap<>();

    String uuid;
    String nickname;

    public User(String uuid, String nickname) {
        this.uuid = uuid;
        this.nickname = nickname;
    }

    public void changeUserName(User user, String nickname) {
        userMap.put(user.uuid, nickname);
    }

    public void enterUser(User user) {
        userMap.put(user.uuid, user.nickname);
    }

    public String getNickname() {
        return userMap.get(this.uuid).intern();
    }
}