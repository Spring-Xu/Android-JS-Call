package com.example.betweenjsandjava;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JsInterface {
	private WebView mWebView;

	public JsInterface(WebView webView) {
		this.mWebView = webView;
	}

	@JavascriptInterface
	public void javaFunction() {
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run() {
				//update UI in main looper, or it will crash
				Toast.makeText(mWebView.getContext(), "javaFunction had been called", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public void javaCallJsFunction(int code){
		mWebView.loadUrl(String.format("javascript:javaCallJsFunction("+code+")"));
	}
}
