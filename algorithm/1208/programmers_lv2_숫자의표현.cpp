#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int temp = 0;
    for(int i = 1 ; i <= n+1 ; i++ )
    {
        for(int j = i ; j <= n+1; j++)
        {
            if(temp > n)
            {
                temp = 0;
                break;
                
            }
            else if(temp == n)
            {
                answer++;
                temp = 0;
                break;
            }
            else
            {
                temp += j;
            }
        }
    }
    return answer;
}