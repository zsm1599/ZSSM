package com.wxzx.gyzs.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/**
 * ---------------------------------------------------------------
 *
 * @copyright Copyright 2014-2016  JR.JD.COM  All Rights Reserved
 * -----------------------------------------------------------------
 * 项目名称:  gyzs
 * <p/>
 * 类名称:    com.wxzx.gyzs.util.ImageWatermarkUtil
 * 功    能:
 * -----------------------------------------------------------------
 * 创建人：   zhaosiming
 * <p/>
 * 创建时间： 2018/10/30 10:08
 * 版本号：   1.0
 * <p/>
 * 修改人：   zhaosiming
 * 修改时间： 2018/10/30 10:08
 * 版本号：   1.0
 * 修改原因：
 * <p/>
 * 复审人：
 * 复审时间：
 * -------------------------------------------------------------
 */

public class ImageWatermarkUtil {

	private static Log logger = LogFactory.getLog(ImageWatermarkUtil.class);
	private static String WATER_WORD="国云装饰";

	/**
	 * 添加文字水印
	 * @param targetImg 目标图片路径，如：C://myPictrue//1.jpg
	 * @param pressText 水印文字， 如：京东小金库
	 * @param fontName 字体名称，    如：宋体
	 * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)
	 * @param fontSize 字体大小，单位为像素
	 * @param color 字体颜色
	 * @param x 水印文字距离目标图片左侧的偏移量，如果x<0, 则在正中间
	 * @param y 水印文字距离目标图片上侧的偏移量，如果y<0, 则在正中间
	 * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 * @param pictureFormat 图片格式,如jpg
	 */
	public static void pressText(String targetImg, String pressText, String fontName, int fontStyle, int fontSize, Color color, int x, int y, float alpha,String pictureFormat) {
		try {
			File file = new File(targetImg);

			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setColor(color);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

			int width_1 = fontSize * getLength(pressText);
			int height_1 = fontSize;
			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			if(x < 0){
				x = widthDiff / 2;
			}else if(x > widthDiff){
				x = widthDiff;
			}
			if(y < 0){
				y = heightDiff / 2;
			}else if(y > heightDiff){
				y = heightDiff;
			}

			g.drawString(pressText, x, y + height_1);
			g.dispose();
			ImageIO.write(bufferedImage, pictureFormat, file);
		} catch (Exception e) {
			logger.error("图片添加水印异常", e);
		}
	}

	/**
	 * 添加文字水印
	 * @param input 图片流
	 * @param pressText 水印文字， 如：京东小金库
	 * @param fontName 字体名称，    如：宋体
	 * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)
	 * @param fontRow 线上行数
	 * @param color 字体颜色
	 * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
	 * @param degree 旋转角度
	 * @param pictureFormat 图片格式,如jpg
	 */
	public static InputStream pressText(InputStream input, String pressText, String fontName, int fontStyle, int fontRow, Color color, float alpha,int degree,String pictureFormat) {
		try {
			BufferedImage bufferedImage = ImageIO.read(input);
			int fontSize = 0;
			if(bufferedImage.getWidth() > bufferedImage.getHeight()){
				fontSize = bufferedImage.getWidth()/fontRow;
			}else{
				fontSize = bufferedImage.getHeight()/fontRow;
			}
			Graphics2D g = bufferedImage.createGraphics();
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setColor(color);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.rotate(Math.toRadians(degree), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

			int width_1 = fontSize * getLength(pressText);
			int height_1 = fontSize;

			for (int height = - height_1 * 10 ; height < bufferedImage.getHeight() / Math.tan(degree); height = height + fontSize + height_1) {
				for (int weight = 0; weight < bufferedImage.getWidth() / Math.tan(degree); weight = weight + fontSize + width_1) {
					g.drawString(pressText, weight - width_1, height - height_1);
				}
			}

			g.dispose();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, pictureFormat, os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (Exception e) {
			logger.error("图片添加水印异常",e);
			return null;
		}
	}

	/**
	 * 获取字符长度，一个汉字作为 1 个字符, 一个英文字母作为 0.5 个字符
	 * @param text
	 * @return 字符长度，如：text="中国",返回 2；text="test",返回 2；text="中国ABC",返回 4.
	 */
	public static int getLength(String text) {
		int textLength = text.length();
		int length = textLength;
		for (int i = 0; i < textLength; i++) {
			if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
				length++;
			}
		}
		return (length % 2 == 0) ? length / 2 : length / 2 + 1;
	}

	/**
	 * 添加文字水印
	 * @param input 图片流
	 * @param waterWord 水印文字， 如：京东小金库
	 * @param fontName 字体名称，    如：宋体
	 * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)
	 * @param color 字体颜色
	 * @param fontSize 字体大小
	 * @param pictureFormat 图片格式,如jpg
	 * @return
	 */
	public static InputStream addWaterMark(InputStream input, String waterWord, String fontName, int fontStyle, Color color, int fontSize, String pictureFormat){
		try {
			BufferedImage bufferedImage = ImageIO.read(input);
			Graphics2D g = bufferedImage.createGraphics();
			g.setBackground(Color.BLACK);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setColor(color);
			if(StringUtils.isBlank(waterWord)){
				waterWord = WATER_WORD;
			}
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			g.drawString(waterWord, width - (waterWord.length()-3) * fontSize, height - fontSize);
			g.dispose();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, pictureFormat, os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (Exception e) {
			logger.error("图片添加水印异常",e);
			return null;
		}
	}
}
