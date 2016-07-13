
public class TrieNode {
	boolean isword;
	TrieNode[] leaves;
	String s;
	public TrieNode(String s){
	    this.leaves=new TrieNode[26];
	    this.s=s;
	}
	public void insert(String s) {
		TrieNode cur = this;
        for(int i=0;i<s.length();i++){
            if(cur.leaves[s.charAt(i)-'a']==null){
                cur.leaves[s.charAt(i)-'a']=new TrieNode(s.substring(0,i+1));
            }
            if(i==s.length()-1){
                    cur.leaves[s.charAt(i)-'a'].isword=true;
            }
            cur=cur.leaves[s.charAt(i)-'a'];
        }
    }
	
}
