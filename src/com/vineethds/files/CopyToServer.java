package com.vineeth.works;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CopyToServer {

	public static void main(String[] args) throws JSchException, SftpException {
		CopyToServer cpy = new CopyToServer();
		String dir= "";
		cpy.copyFiles(dir);
	}

	private void copyFiles(String dir) throws JSchException, SftpException {
		
		 System.out.println(System.getProperty("os.name"));
	        String hostname = "lxdenvd484";
	        String username = "plaidapp";
	        String password = "Pl@id2018";
	        String copyFrom = "C:/Work_spaces/TestCopy";
	        String copyTo = "/opt/plaid/jenkins"; 
	        System.out.println("Initiate sending file to Linux Server...");
	        JSch jsch = new JSch();
	        Session session = null;
	        System.out.println("Trying to connect.....");
	        session = jsch.getSession(username, hostname, 22);
	        session.setConfig("StrictHostKeyChecking", "no");
	        session.setPassword(password);
	        session.connect();
	        System.out.println("is server connected? " + session.isConnected());
	        
	        Channel channel = session.openChannel("sftp");
	        channel.connect();
	        ChannelSftp sftpChannel = (ChannelSftp) channel;
	        System.out.println("Server's home directory: " + sftpChannel.getHome());
	        try {
	        	InputStream in = new FileInputStream(new File(copyFrom));
	            sftpChannel.put(in, copyTo, ChannelSftp.OVERWRITE);
	        } catch (SftpException e) {
	            System.out.println("file was not found: " + copyFrom);
	        } catch (FileNotFoundException e) {
	        	System.out.println("file was not found: " + copyFrom);
			}

	        sftpChannel.exit();
	        session.disconnect();
	       System.out.println("Finished sending file to Linux Server...");
	}

}
