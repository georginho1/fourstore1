package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {
	AMARELO("11" , "Amarelo"), 
	AZUL("22" , "Azul"), 
	BRANCO("33", "Branco"), 
	CINZA("44", "Cinza"), 
	LARANJA("55", "Laranja"), 
	MARROM("66" , "Marrom"), 
	PRETO("77", "Preto"), 
	ROXO("88" , "Roxo"), 
	VERDE("99" , "Verde"), 
	VERMELHO("10", "Vermelho");

	private String key;
	private String description;
	
	public static final Map<String, ColorEnum> colorMap = new HashMap<String, ColorEnum>();
	static {
		for (ColorEnum color : EnumSet.allOf(ColorEnum.class)) {
			colorMap.put(color.getKey(), color);
		}
	}
	
	public static ColorEnum get(String string) {
		return colorMap.get(string);
	}
	
	ColorEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}
	
	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}

}