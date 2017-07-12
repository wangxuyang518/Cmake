package xinyi.com.cmake;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wxy on 2017/7/10.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {

	public Button decode;
	public Button encode;
	public EditText content;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		decode=findViewById(R.id.decode);
		encode=findViewById(R.id.encode);
		content=findViewById(R.id.content);
		decode.setOnClickListener(this);
		encode.setOnClickListener(this);
		initView();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.encode:
				enCode(content.getText().toString());
				break;
			case R.id.decode:
				deCode(content.getText().toString());
				break;
		}
	}

	public abstract void initView();
	public abstract void deCode(String content);
	public abstract void enCode(String content);
}
