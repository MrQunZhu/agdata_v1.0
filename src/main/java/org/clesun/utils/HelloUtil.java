package org.clesun.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HelloUtil {
	/**  
     * 发送POST请求  
     *   
     * @param url 目的地址  
     * @param parameters  请求参数，Map类型 
     * @return 远程响应结果  
     */  
    public static String sendPost(String url, Map<String, String> parameters) throws Exception{ 
    	return sendPost(url,parameters,false);
    }
	/**  
     * 发送POST请求  
     *   
     * @param url 		     目的地址  
     * @param parameters  请求参数，Map类型 
     * @param resultline  结果是否换行
     * @return 远程响应结果  
     */  
    public static String sendPost(String url, Map<String, String> parameters,boolean resultline) throws Exception{  
    	//设置代理   
    	//System.setProperty("http.proxySet", "true");   
    	//System.setProperty("http.proxyHost", "222.139.5.210");  //110.4.12.170:83//浙江省杭州市 华数宽带218.108.192.205:843
    	//System.setProperty("http.proxyPort", "9000");   

        String result = "";						// 返回的结果  
        BufferedReader in = null;				// 读取响应输入   
        PrintWriter out = null;   
        StringBuffer sb = new StringBuffer();	// 处理请求参数   
        String params = "";						// 编码之后的参数  
        try {   
            // 编码请求参数   
        	if(parameters!=null&&parameters.size()>0){
        		if (parameters.size() == 1) {   
                    for (String name : parameters.keySet()) {   
                        sb.append(name).append("=").append(   
                                java.net.URLEncoder.encode(parameters.get(name),   
                                        "UTF-8"));   
                    }   
                    params = sb.toString();   
                } else {   
                    for (String name : parameters.keySet()) {   
                        sb.append(name).append("=").append(   
                                java.net.URLEncoder.encode(parameters.get(name),   
                                        "UTF-8")).append("&");   
                    }   
                    String temp_params = sb.toString();   
                    params = temp_params.substring(0, temp_params.length() - 1);   
                }  
        	}
             
            // 创建URL对象   
            java.net.URL connURL = new java.net.URL(url);   
            // 打开URL连接   
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL   
                    .openConnection();   
            // 设置通用属性 
            httpConn.setRequestProperty("Accept", "*/*");   
            httpConn.setRequestProperty("Connection", "Keep-Alive");   
            httpConn.setRequestProperty("User-Agent",   
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");   
            // 设置POST方式   
            httpConn.setDoInput(true);   
            httpConn.setDoOutput(true);   
            // 获取HttpURLConnection对象对应的输出流   
            out = new PrintWriter(httpConn.getOutputStream());   
            // 发送请求参数 
            out.write(params);   
            // flush输出流的缓冲   
            out.flush();   
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式   
            in = new BufferedReader(new InputStreamReader(httpConn   
                    .getInputStream(), "UTF-8"));   
            String line;   
            // 读取返回的内容   
            while ((line = in.readLine()) != null) {   
                result += line+(resultline==true?"\r\n":"");   
            }   
            httpConn.disconnect();
        } catch (Exception e) {   
            throw new Exception(e);
        } finally {   
            try {   
                if (out != null) {   
                    out.close();   
                }   
                if (in != null) {   
                    in.close();   
                }   
            } catch (IOException ex) {   
                ex.printStackTrace();   
            }   
        }   
        return result;   
    }  
    
    
    /**  
     * 发送GET请求  
     *   
     * @param url  目的地址  
     * @param parameters 请求参数，Map类型 
     * @return 远程响应结果  
     */  
    public static String sendGet(String url, Map<String, String> parameters) {   
        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入  
        StringBuffer sb = new StringBuffer();// 存储参数   
        String params = "";// 编码之后的参数
        try {   
            // 编码请求参数   
        	if(parameters!=null){
	            if (parameters.size() == 1) {   
	                for (String name : parameters.keySet()) {   
	                    sb.append(name).append("=").append(   
	                            java.net.URLEncoder.encode(parameters.get(name),   
	                                    "UTF-8"));
	                }   
	                params = sb.toString();   
	            } else {   
	                for (String name : parameters.keySet()) {   
	                    sb.append(name).append("=").append(   
	                            java.net.URLEncoder.encode(parameters.get(name),   
	                                    "UTF-8")).append("&");   
	                }   
	                String temp_params = sb.toString();   
	                params = temp_params.substring(0, temp_params.length() - 1);   
	            }   
        	}
            String full_url = url + "?" + params;   
            System.out.println(full_url);   
            // 创建URL对象   
            java.net.URL connURL = new java.net.URL(full_url);   
            // 打开URL连接   
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL   
                    .openConnection();   
            // 设置通用属性   
            httpConn.setRequestProperty("Accept", "*/*");   
            httpConn.setRequestProperty("Connection", "Keep-Alive");   
            httpConn.setRequestProperty("User-Agent",   
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");   
            // 建立实际的连连  
            httpConn.connect();   
            // 响应头部获取   
            Map<String, List<String>> headers = httpConn.getHeaderFields();   
            // 遍历所有的响应头字   
            for (String key : headers.keySet()) {   
                System.out.println(key + "\t：\t" + headers.get(key));   
            }   
            // 定义BufferedReader输入流来读取URL的响应?,并设置编码方   
            in = new BufferedReader(new InputStreamReader(httpConn   
                    .getInputStream(), "GBK"));
            String line;   
            // 读取返回的内容
            while ((line = in.readLine()) != null) {   
                result += line;   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                if (in != null) {   
                    in.close();   
                }   
            } catch (IOException ex) {   
                ex.printStackTrace();   
            }   
        }   
        return result;   
    }  
    
    /**
     * 保存图片
     * @param streamByte	图片流
     * @param targetDir		目标路径
     * @return				保存后的文件名
     */
    public static String saveImage(byte[] streamByte,String targetDir) throws FileNotFoundException,
		IOException, URISyntaxException {
		String filename = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS") + ".jpg";
		
		FileOutputStream imgout = new FileOutputStream(new File(targetDir+ "/" + filename));
		imgout.write(streamByte, 0, streamByte.length);
		imgout.close();
		return filename;
    }
    
    /**
     * 获取图片文件的字符串
     * @return
     */
    public static String getImageStr(String sourceFile) throws Exception{
    	File file = new File(sourceFile);
		InputStream  input = new FileInputStream(file);
		byte[] data = null;
		data = new byte[input.available()];
		input.read(data);
		input.close();
		return Base64.encode(data);
    }
    
    public static void main(String[] args) {
    	/*Map map = new HashMap<String, Object>();
    	map.put("aa","bb");
		String result = sendPost("http://192.168.3.104:8080/tjnjtg/httpMobile.action", map);
		System.out.println(result);*/
    }
}
