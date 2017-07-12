package xinyi.com.cmake;

import android.view.View;

/**
 * Created by wxy on 2017/7/10.
 */

public class MD5Activity extends BaseActivity {
	@Override
	public void initView() {
		decode.setVisibility(View.INVISIBLE);
	}

	@Override
	public void deCode(String c) {
		content.setText(m5DeCode(c));
	}
	@Override
	public void enCode(String c) {
		content.setText(m5EnCode(c));
	}

	public native String m5EnCode(String c);
	public native String m5DeCode(String c);
	static {
		System.loadLibrary("md5");
		System.loadLibrary("crypto");//去掉lib  以及后面的.so
		System.loadLibrary("ssl");
	}
}
