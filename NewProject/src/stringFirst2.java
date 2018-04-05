
public class stringFirst2 {

	public static void main(String[] args) {
		int[] hello = new int[4];
        hello[0] = 4;
        hello[1] = 0;
        hello[2] = 3;
        hello[3] = 0;
        
        
		
	}
	
	public int[] zeroMax(int[] nums)
	{
		int max;
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(nums[i] == 0)
			{
				max = 0;
				for(int k = i + 1; k < nums.length; k++)
				{
					if(nums[k] > max && nums[k] % 2 == 1)
						max = nums[k];
				}
				if(max != 0)
					nums[i] = max;
			}
		}
		return nums;
	}
}
