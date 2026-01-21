public class deneme2 {
    
 int gcd(int... nums) {

    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
        result = gcd(result, nums[i]);
    }

    return result;
}

static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
        int r = a % b; //r=4
        a = b;//a=12
        b = r;//4
    }
    return a;
}


}

