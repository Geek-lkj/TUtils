package cn.lkj.TUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

/**
 * Other������ ʹ��ǰ���ñ����init������ʼ��
 * 
 * @author LKJ 
 * 
 *  �������
 *  
 *  MD5 ����    				MD5(Strint)
 *  
 *  MD5 ����    				MD5(InputStream)
 *  
 *  Toast    				show(String)
 *  
 *  Toast   				show(int)
 *  
 *  Toast   				show(Object)
 *  
 *  zipѹ��      				StartZip(String,String)
 *  
 *  zip��ѹ��				Unzip(String,String)
 *  
 *  zip��ѹ��				Unzip2(InputStream,File)
 *  
 *  ��ȡ�ֻ�ͨ��¼��Ա�б� 	getContactsList()
 *  
 *  ��ȡ�ֻ�ͨѶ¼��Աͷ��	getContactsBitMap()
 * 
 */
public final class OUtils {

	private static Context context;
	
	private static final String AUTHORITY = "com.android.contacts";
	
	private static final Uri RAW_CONTACT_URI = Uri.parse("content://"
			+ AUTHORITY + "/raw_contacts");
	
	private static final Uri DATA_URI = Uri.parse("content://" + AUTHORITY
			+ "/data");
	
	
	
	private OUtils() {
	}

	/**
	 * ��ʼ������
	 * 
	 * @param contexts
	 *            �����Ķ���
	 */
	public static void init(Context contexts) {
		context = contexts;
	}

	/**
	 * Toast.show()
	 * 
	 * @param str
	 */
	public static void show(String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Toast.show()
	 * 
	 * @param str
	 */
	public static void show(int str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	// //////////////////////////////////////

	

	/**
	 * ZIPѹ��
	 * 
	 * @param name
	 *            �ļ�·��
	 * @param path
	 *            ѹ����·��
	 */
	public static void startZip(String name, String path) {
		FileInputStream is = null;
		FileOutputStream os = null;
		GZIPOutputStream gs = null;
		File infile = new File(name);
		File outfile = new File(path);
		try {
			is = new FileInputStream(infile);
			os = new FileOutputStream(outfile);

			gs = new GZIPOutputStream(os);

			byte[] b = new byte[1024 * 8];
			int length = -1;

			while ((length = is.read(b)) != -1) {
				gs.write(b, 0, length);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (gs != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	/************
	 * ��ѹ��
	 * 
	 * @param ѹ����·��
	 * @param ��ѹ������
	 */
	public static void unZip2(InputStream is, File outfile) {

		FileOutputStream os = null;
		GZIPInputStream gs = null;

		try {

			os = new FileOutputStream(outfile);

			gs = new GZIPInputStream(is);

			byte[] b = new byte[1024 * 8];

			int length = -1;

			while ((length = gs.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gs != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/************
	 * ��ѹ��
	 * 
	 * @param ѹ����·��
	 * @param ��ѹ������
	 */
	public static void unZip(String name, String path) {
		FileInputStream is = null;
		FileOutputStream os = null;
		GZIPInputStream gs = null;
		File infile = new File(name);
		File outfile = new File(path);

		try {
			is = new FileInputStream(infile);
			os = new FileOutputStream(outfile);

			gs = new GZIPInputStream(is);

			byte[] b = new byte[1024 * 8];

			int length = -1;

			while ((length = gs.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gs != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					gs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// //////////////////////////////////////////
	/**
	 * �ַ���MD5����
	 * 
	 * @param msg
	 * @return ���ַ�������ȡժҪ
	 */
	public static String md5(String msg) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bytes = digest.digest(msg.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				int i = (b & 0xff);

				String hex = Integer.toHexString(i);

				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �ֽ������� ����ȡ�ļ�MD5
	 * 
	 * @param is
	 * @return ��һ�������м���
	 */
	public static String md5(InputStream is) {
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("MD5");
			byte[] bytes = new byte[8192];
			int byteCount;
			while ((byteCount = is.read(bytes)) > 0) {
				digester.update(bytes, 0, byteCount);
			}
			byte[] digest = digester.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				int i = (b & 0xff);
				String hex = Integer.toHexString(i);
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	/////////////////////////////
	/******************
	 * ��ȡͨ��¼List
	 * 
	 * @param context
	 * @return ����List<ContactBean> ͨѶ¼�б�
	 ******************/
	public static List<ContactBean> getContactsList(Context context) {

		List<ContactBean> list = new ArrayList<ContactBean>();

		ContentResolver cr = context.getContentResolver();

		Cursor cursor = cr.query(RAW_CONTACT_URI, new String[] { "_id",
				"display_name" }, null, null, null);

		while (cursor.moveToNext()) {
			int id = cursor.getInt(0);
			String name = cursor.getString(1);

			ContactBean cb = new ContactBean();

			cb.id = id;
			cb.name = name;

			Cursor cursor2 = cr.query(DATA_URI, new String[] { "data1",
					"mimetype" }, "raw_contact_id=?",
					new String[] { String.valueOf(cb.id) }, null);

			while (cursor2.moveToNext()) {
				String mietype = cursor2.getString(1);
				if ("vnd.android.cursor.item/phone_v2".equals(mietype)) {
					cb.phoneNum = cursor2.getString(0);
				}

			}
			cursor2.close();
			list.add(cb);
		}
		cursor.close();
		return list;
	}

	/******************
	 * ��ȡͨѶ¼ͷ��
	 * 
	 * @param context
	 * @param ͨ��getContacts
	 *            ���ض������id ��ȡ
	 * @return ���� BitMap ͼƬ
	 *******************/
	public static Bitmap getContactsBitMap(Context context, int id) {

		ContentResolver cr = context.getContentResolver();

		Cursor cursor = cr.query(DATA_URI, new String[] { "data15" },
				"raw_contact_id=?", new String[] { String.valueOf(id) }, null);

		if (cursor != null) {

			while (cursor.moveToNext()) {

				byte[] b = cursor.getBlob(0);
				if (b == null) {
					continue;
				}

				return BitmapFactory.decodeByteArray(b, 0, b.length);
			}

			cursor.close();
		}

		return null;

	}
	/**
	 * ͨѶ¼javaBean
	 * @author Administrator
	 *
	 */
	public static class ContactBean {
		public int id;
		public String name;
		public String phoneNum;
		public int image;
	}
}
