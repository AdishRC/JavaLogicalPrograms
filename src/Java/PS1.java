package Java;
public class PS1 extends PS {

	@Test
	public void testRun()
	{
		PS2 ps2 = new PS2(3);
		int a=3;
		doThis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());

		//		PS3 ps3 = new PS3(3);
		System.out.println(ps2.multiplyThree());
		System.out.println(ps2.multiplyTwo());
	}
}


