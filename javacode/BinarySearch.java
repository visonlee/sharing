public class BinarySearch {

    int binary_search(int a[], int len, int key){
        int low = 0; 
        int high = len - 1; 
    
        while ( low <= high ) {
            int mid = (low + high)/2;   //may bug here
            if (a[mid] == key) {
                return mid;
            }
            if (key < a[mid]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
