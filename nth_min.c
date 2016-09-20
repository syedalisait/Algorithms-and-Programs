/**
 * Quick Sort
 * author: yusuf shakeel	date: 21-10-2012
 */

#include <stdio.h>
#define SIZE 6	//array size


int partitionArray(int *a, int beg, int end, int *pivotLoc);
int quickSort(int *a, int beg, int end, int n);

int main(){
	int a[SIZE] = {65,42,71,35,45,11};	//unsorted array
	int i,n,f;
    printf("Enter the smallest nth element to be found\n");
    scanf("%d",&n);
    if(n<=SIZE && n>0)
	{
	    f=quickSort(a, 0, SIZE-1,n-1);	//beg = 0 start index of array end = 5 last index of array

        printf("the %d smallest element is %d\n",n,a[f]);
	//printing sorted element of array
        for(i = 0; i < SIZE; i++)
		printf("%d\t", a[i]);
	}
	else
    printf("n is larger or smaller than array size\n");
	return 0;
}//main() ends here

int quickSort(int *a, int beg, int end, int j){
	int pivotLoc,i,k;
	if(beg < end)
    {
		i=partitionArray(a, beg, end, &pivotLoc);
        //for(k=0;k<SIZE;k++)
            //printf("Array=%d\t",a[k]);
        printf("\n");
        printf("i=%d j=%d\n",i,j);
		if(i>j)	//this will find the pivot location and partition the array
        quickSort(a, beg, i - 1, j);
		else if(i<j)	//quick sort the left sub array
        quickSort(a, i + 1, end, j);
		else if(i==j)
		{
                //printf("the %d smallest element is %d\n",j+1,a[i]);//quick sort the right sub array
                return i;
		}
	}
	return j;
	//else
      //  printf("the %d smallest element is %d\n",j+1,a[pivotLoc]);
}//quickSort() ends here

int partitionArray(int *a, int beg, int end, int *pivotLoc){
	int left = beg;		//initially left point to the first element of the array
	int right = end;	//initially right point to the last element of the array
	*pivotLoc = left;	//initially pivot point to first element of the array
	int tmp;	//used for swapping values

	while(1){

		//pivot pointing at left
		while(a[*pivotLoc] <= a[right] && *pivotLoc != right){	//pivot element <= right element
			right--;	//move right one position towards left
		}

		if(*pivotLoc == right){	//both left and right pointing at same element of the array
			break;
		}else if(a[*pivotLoc] > a[right]){
			//pivot element greater than right element. swap pivot and right element.
			tmp = a[right];
			a[right] = a[*pivotLoc];
			a[*pivotLoc] = tmp;
			*pivotLoc = right;	//pivot is now pointing to right
		}

		//pivot pointing to right
		while(a[*pivotLoc] >= a[left] && *pivotLoc != left){	//pivot element >= left element
			left++;		//move left one position towards right
		}

		if(*pivotLoc == left){	//both left and right pointing at the same element of the array
			break;
		}else if(a[*pivotLoc] < a[left]){
			//pivot element smaller than left element. swap pivot and left element.
			tmp = a[left];
			a[left] = a[*pivotLoc];
			a[*pivotLoc] = tmp;
			*pivotLoc = left;	//pivot is now pointing to left
		}
	}
	return *pivotLoc;
}//partitionArray() ends here
