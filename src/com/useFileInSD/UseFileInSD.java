package com.useFileInSD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;

public class UseFileInSD {
	private String sdState = Environment.getExternalStorageState();
	private String path = Environment.getExternalStorageDirectory().toString();

	public String FILE_ROOT = "/ManChat";
	public String FILE_UserHeadImg = "/UserHeadImg";// �����û�ͷ�񱣴�·��
	public String FILE_SendBox = "/SendBox/";// ���巢����·��

	static int i = 1;

	public void UseFileInSd() {
	};

	// �ж��Ƿ���SD��
	public boolean ifHasSD() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}

	// ��SD���д����û���ͷ�񣬴������λDrawable��FileName

	public void saveUserHeadImg(Drawable UserHeadImg, String imageName) {
		File file;
		File PicName;
		BitmapDrawable bd = (BitmapDrawable) UserHeadImg;
		Bitmap bitmap = bd.getBitmap();
		if (sdState.equals(Environment.MEDIA_MOUNTED)) {
			// ���sd����Ŀ¼
			file = new File(path + FILE_ROOT + FILE_UserHeadImg);
			if (!file.exists()) {
				file.mkdirs();
			}
			PicName = new File(file, imageName);
			try {
				if (!PicName.exists()) {
					PicName.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(PicName);
				if (PicName.getName().endsWith(".png")) {
					bitmap.compress(CompressFormat.PNG, 100, fos);
				} else if (PicName.getName().endsWith(".jpg")) {
					bitmap.compress(CompressFormat.JPEG, 100, fos);
				}
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveMail(String content, String filename) throws IOException {

		File file = new File(Environment.getExternalStorageDirectory(),
				(FILE_ROOT + FILE_SendBox + filename + i + ".txt"));
		i++;
		FileOutputStream outStream = new FileOutputStream(file);
		outStream.write(content.getBytes());
		outStream.close();
	}
	// ���ļ��ж�ȡ����

	/*
	 * public String readFile(String filename) throws IOException { File file =
	 * new File(Environment.getExternalStorageDirectory(), (FILE_ROOT +
	 * FILE_SendBox + filename)); FileReader inStream = new FileReader(FILE_ROOT
	 * + FILE_SendBox + filename + ".txt"); BufferedReader m_Readbuf = new
	 * BufferedReader(inStream); return m_Readbuf.readLine();
	 * 
	 * 
	 * }
	 */

}
