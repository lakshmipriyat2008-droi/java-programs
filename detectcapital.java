public class Detectcapital {
    public boolean detectCapitalUse(String word) {
        int capcount = 0;
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                capcount++;
                
            }
        }
        if(capcount==word.length())return true;
        if(capcount==0)return true;
        if(capcount==1&&Character.isUpperCase(word.charAt(0)))return true;
        return false;
        
    }
}