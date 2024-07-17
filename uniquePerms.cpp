
class Solution {
  public:
  set<vector<int>>st;
  void perm(vector<int>temp,int l,int h){
      if(l==h){
          st.insert(temp);
      }
      else{
          for(int i=l;i<=h;i++){
              swap(temp[l],temp[i]);
              perm(temp,l+1,h);
              swap(temp[l],temp[i]);
          }
      }
  }
    vector<vector<int>> uniquePerms(vector<int> &arr ,int n) {
        // code here
    perm(arr,0,n-1);
        vector<vector<int>>ans;
       ans.insert(ans.begin(),st.begin(),st.end());
       return ans;
    }
};
