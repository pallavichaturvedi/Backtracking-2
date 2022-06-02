class PallindromePartioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s.length() == 0 || s == null) return result;
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int idx, List<String> path){

        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i< s.length(); i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else return false;
        }
        return true;
    }
}