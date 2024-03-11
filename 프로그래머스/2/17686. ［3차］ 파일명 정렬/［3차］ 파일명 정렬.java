import java.util.*;

class Solution {
	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
        String[][] file = new String[files.length][3];
        
        for(int i=0;i<files.length;i++){
            String f=files[i];
            int idx=0;
            file[i][0]=file[i][1]=file[i][2]="";
            while(f.charAt(idx)<'0'||f.charAt(idx)>'9'){
                file[i][0]+=f.charAt(idx);
                if(idx>=f.length()-1)
                    break;
                else idx++;
            }
            while(f.charAt(idx)>='0'&&f.charAt(idx)<='9'){
                file[i][1]+=f.charAt(idx);
                if(idx>=f.length()-1)
                    break;
                else idx++;
            }
            if(idx<f.length()-1)
            file[i][2]=f.substring(idx,f.length());
            System.out.println(file[i][0]+"/"+file[i][1]+"/"+file[i][2]);
        }
		
        Arrays.sort(file,new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase())!=0){
                    return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
                }else{
                    return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                }
            }
        });
            
        for(int i=0;i<answer.length;i++){
            answer[i]=file[i][0]+file[i][1]+file[i][2];
        }
		return answer;
	}
}