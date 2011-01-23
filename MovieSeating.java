// Compute the number of ways in which numFriends people can be seated
// in a hall, if all of them must sit in the same row or the same
// column, though not necessarily next to one another

public class MovieSeating {
  
  private static long perm(int n, int r) {
    long p = 1;
    for(int i = n; i >= (n - r + 1); i--)
      p *= i;
      
    return p;
  }
  
  public long getSeatings(int numFriends, String[] hall) {
    // For each row
    // Get # of empty seats
    // Compute nPr
    // Add
    long sum = 0;

    for(int i = 0; i < hall.length; i++) {
      int empty = 0;
      for(int j = 0; j < hall[i].length(); j++)
        if(hall[i].charAt(j) == '.')
          empty++;
      if(empty >= numFriends)
        sum += perm(empty, numFriends);
    }
    
    // Repeat the process for each column
    if(numFriends > 1) {
    int w = hall[0].length();
    
    for(int i = 0; i < w; i++) {
      int empty = 0;
      for(int j = 0; j < hall.length; j++)
        if(hall[j].charAt(i) == '.')
          empty++;
      if(empty >= numFriends)
        sum += perm(empty, numFriends);
    }
    }
    
    return sum;
  }
}
