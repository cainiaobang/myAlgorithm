/**
 Implement regular expression matching with support for '.' and '*'.
 '.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "a*") �� true
isMatch("aa", ".*") �� true
isMatch("ab", ".*") �� true
isMatch("aab", "c*a*b") �� true
 */


package cn.itcst.day5;

import java.util.ArrayList;

import org.junit.Test;

public class Regular_Expression_Matching {

	
	
	//�Լ������������Ŀ���о����ʵ�ڱȽ϶࣬�޷��ҵ��������򻯽���˼·
	public boolean isMatch(String s, String p) {	 
		 int length1=s.length();
		 int length2=p.length();
		 if(length1==0||length2==0) return false;
		 boolean flag=true;
		 int length=Math.max(length1, length2);
		 for(int i=0;i<length;i++){
			 if(s.charAt(i)!='*'&&p.charAt(i)!='*'){
				 if(s.charAt(i)==p.charAt(i)) continue;
				 else if(s.charAt(i)=='.'||p.charAt(i)=='.'){
					 continue;
				 }else{
					 return false; 
				 }
					 
			 }else if(s.charAt(i)=='*'&&p.charAt(i)=='*'){
				 if(i==0) continue;
			
			 }
			 else if(s.charAt(i)=='*'){
				 if(i==0){
					 if (p.charAt(i)!='*') return false; 
				 }
				 else{
					 if(s.charAt(i)!='.'){
						 
					 }
				 }
			 }else if(p.charAt(i)=='*'){
				 
			 }
			
		 }
		 return flag;
	 }
	
	
	
	
//  brute force
	/*
(1)p[j+1]����'*'������Ƚϼ򵥣�ֻҪ�жϵ�ǰs��i��p��j�ϵ��ַ��Ƿ�һ���������p��j�ϵ��ַ���'.',Ҳ����ͬ���������ͬ������false��
���򣬵ݹ���һ��i+1��j+1; 
(2)p[j+1]��'*'����ô��ʱ����s[i]��ʼ���Ӵ�������s[i],s[i+1],...s[i+k]������p[j]��ô��ζ����Щ���п����Ǻ��ʵ�ƥ�䣬
��ô�ݹ����ʣ�µ�(i,j+2),(i+1,j+2),...,(i+k,j+2)��Ҫ���ԣ�j+2����Ϊ������ǰ����һ��'*'�ַ����� 
ʵ�ִ������£�
	 */
	public boolean isMatch5(String s, String p) {  
	    return helper(s,p,0,0);  
	}  
	private boolean helper(String s, String p, int i, int j)  
	{  
	    if(j==p.length())  
	        return i==s.length();  
	      
	    if(j==p.length()-1 || p.charAt(j+1)!='*')  
	    {  
	        if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')  
	            return false;  
	        else  
	            return helper(s,p,i+1,j+1);  
	    }  
	    //p.charAt(j+1)=='*'  
	    while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)))  
	    {  
	        if(helper(s,p,i,j+2))  
	            return true;  
	        i++;  
	    }  
	    return helper(s,p,i,j+2);  
	}  
	
	
	
	// �ο����˵Ĵ�  �ݹ���,����˼·��������������Ľⷨ��һ��˼·
	boolean isMatch3(String s, String p){
		if(p.isEmpty()) return s.isEmpty();
		
		if('*'==p.charAt(1))
			return (isMatch(s,p.substring(2))||!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||'.'
			==p.charAt(0))&&isMatch(s.substring(1),p));
		else
			return !s.isEmpty()&&(s.charAt(0)==p.charAt(0)|| '.'==p.charAt(0))
					&&isMatch(s.substring(1),p.substring(1));
		
	}
	
	
	//���ö�̬�滮����������⡣
	/*
	 * (1)p[j+1]����'*'������Ƚϼ򵥣�ֻҪ�ж������ǰs��i��p��j�ϵ��ַ�һ�������
	 * ��p��j�ϵ��ַ���'.',Ҳ����ͬ��������res[i][j]==true����res[i+1][j+1]ҲΪtrue��res[i+1][j+1]=false; 
      (2)p[j+1]��'*'������p[j]!='.'����ôֻҪ����������һ�����㼴�ɶ�res[i+1][j+1]��ֵΪtrue�� 
    1)res[i+1][j]Ϊ�棨'*'ֻȡǰ���ַ�һ�Σ�; 
    2)res[i+1][j-1]Ϊ�棨'*'ǰ���ַ�һ�ζ���ȡ��Ҳ���Ǻ����������ַ���; 
    3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](����������൱��i��0��s.length()ɨ���������p[j+1]��Ӧ���ַ��ǡ�*��
         �Ǿ���ζ�Ž������Ĵ��Ϳ�������ƥ�����������������ַ�һֱ�ظ������Ҿ��ǡ�*��ǰ����Ǹ��ַ����� 
   (3)p[j+1]��'*'������p[j]=='.'����Ϊ".*"����ƥ�������ַ�����������ǰ���res[i+1][j-1]����res[i+1][j]��ֻҪ��i+1��true��
        ��ôʣ�µ�res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]�Ͷ���true�ˡ� 
	 */
	public boolean isMatch4(String s, String p) {  
	    if(s.length()==0 && p.length()==0)  
	        return true;  
	    if(p.length()==0)  
	        return false;  
	    boolean[][] res = new boolean[s.length()+1][p.length()+1];  
	    res[0][0] = true;  
	    for(int j=0;j<p.length();j++)  
	    {  
	        if(p.charAt(j)=='*')  
	        {  
	            if(j>0 && res[0][j-1]) res[0][j+1]=true;  
	            if(j<1) continue;  
	            
	            if(p.charAt(j-1)!='.')  
	            {  
	                for(int i=0;i<s.length();i++)  
	                {  
	                    if(res[i+1][j] || j>0&&res[i+1][j-1]   
	                    || i>0 && j>0 && res[i][j+1]&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==p.charAt(j-1))  
	                        res[i+1][j+1] = true;  
	                }  
	            }  
	            else  
	            {  
	                int i=0;  
	                
	                
	                while(j>0 && i<s.length() && !res[i+1][j-1] && !res[i+1][j])  
	                    i++;  
	                for(;i<s.length();i++)  
	                {  
	                    res[i+1][j+1] = true;  
	                }  
	            }  
	        }  
	        else  
	        {  
	            for(int i=0;i<s.length();i++)  
	            {  
	                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')  
	                {
	                	res[i+1][j+1] = res[i][j];  
	                	System.out.println(i+" "+j+" "+res[i][j]);
	                }
	            }  
	        }  
	    }  
	    return res[s.length()][p.length()];  
	}  
	
	
	
	
	//
	
	@Test
	public void Test(){
		boolean[][] am=new boolean[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.println(am[i][j]);
			}
		}
		
	}
	
	
	
}
