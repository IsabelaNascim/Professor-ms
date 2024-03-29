package br.com.nava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
	
	private Long timestamp;
	private Integer Status;
	private String error;
	private String message;
	private String path;
}
