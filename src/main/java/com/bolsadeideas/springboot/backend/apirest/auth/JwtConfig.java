package com.bolsadeideas.springboot.backend.apirest.auth;

public class JwtConfig {
	public static  final String LLAVE_SECRETA ="alguna.clave.secreta.12345";
	
	public static  final String RSA_PRIVADA ="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEA5E3cSmAZRktPuc5BjVQRiPcS8QW9713kJ0wQnla2povXPHtG\r\n"
			+ "Pd4CdzRA+t63G/x8zaYegAOq+DB1mONOSio3qQfcL3DWj5UcOYQTHgnqeDubspSh\r\n"
			+ "5x9I6gLcK+hu/k/bpRIAY7/hgjkdqgUA0PL/fA6XtALdys+1QSxP6oMNjD3x1b38\r\n"
			+ "TxbIZpbMuEjl6IQN52m7+mC/HEEP5oz/MiBiH2Art/FO4SAOrQNuPOBjGI9WLjq2\r\n"
			+ "k2Beh8pEIuOHTrjJEkGVKUIxHyyurNKAqCvLyJi56hL/UpKQHzmD5zz9Hy66xX87\r\n"
			+ "VRBLvVyxxdyVQEIn5Xiyk+R7tPn0vKV80hcemwIDAQABAoIBAAwAP8U1Gf8E9HLq\r\n"
			+ "8a0xLx7JBhjfWWWcxOJ/8BuyqTVGApFuVXnpEq4bdBL75Bo3goP46H+IMdOMEJJx\r\n"
			+ "2Gqzn2tmO1/PCahQiURIugyJLucVExEnGP+iOF38uoAgXr1Fi2E4+gZETuFeiT2n\r\n"
			+ "t6xEKcPmrHjM8cW4d2mun6DPNMYbXgeGeUlW7yQjknVRSYXph2d9p3JwaqiCavIq\r\n"
			+ "srZNHKHGk+eSvXSvDdA0LF/Jp9FTNc/azypuio2SBO4lzpT8IKtc/YZD4SJaA5wZ\r\n"
			+ "A3TbUObF6oUFa5Qt033T+WWImaE+zVFnyQ/pwga1f/MjtS/IyOTrcYnfZmOTDdO4\r\n"
			+ "ib8BpYECgYEA/283WFjM+wrX0AE1/dldgNAHA8wFWtDprjAE2sXDIB7Ic9WA+DeQ\r\n"
			+ "JZnnbAR5VKNQWdh4+v+gm5JoWfG3ZA8ZlPdM9UYmo1JydVcVwnKErrq6JZZe0khD\r\n"
			+ "LC2BPEvT1S7npEdK8KrdSlIJiarr2+mC1KcKdxXgdbSpfdKUCxQExsECgYEA5M9E\r\n"
			+ "OIXXB+jiF3mjTcaLlwwpDx4X1hG+tsFVUqUAhe446/cMnI6fs6BM77hJ9L968bQo\r\n"
			+ "zMyeUqq7bAASmE2dJgYsg7RWFLsHzp3Yt4gBfj7tkYIA9/AfaQXl0L8nhxFQVbdE\r\n"
			+ "Yd9FN1WDQs8+R65vnSFso0fZDW8nHjRG/M+6eFsCgYB8RRNb+/fduqy8GZq24WVI\r\n"
			+ "Ie0Hv95rDHBjuiDifowruE41bI3ONNoAMRwRxStyLfINg+93zZ3JkjUKbTqXh3Ee\r\n"
			+ "tCHQwkxR8O6Wf8OqUiSTDW06lCmVjGqBt7HEL+/jK2qu1bBz3ezDF55kR69v0e9A\r\n"
			+ "nfPNc+s72KUM/cHgkeCxAQKBgFIEievI7h+Dtye7DnKerQLj9QPaQakWi0pvWupZ\r\n"
			+ "Ayr/DaBn2jl0VoLI/0sewEPfL27cqZNf9ZCkarJ4BDJb/+zVYbeEOScNM+s4YarI\r\n"
			+ "MeDTJc120GoPxPKcjpiZLM4ZwrY3D2gV5HXFTVvxdd20BYZJqOuOoZtTMK5/BsMw\r\n"
			+ "oyLpAoGBALtxdnzJ0t54zbkOlNm6bsMC+7GSZtxaPbKBhXzW1epm6PH2cGzwejq+\r\n"
			+ "RAh3JKg3WSJ507d650OSjsZmywqtzd41e0NtvTRzJLaX05ECJGisixy2wNUTls7K\r\n"
			+ "ittBEEddgfCVPdTXDtl94JnRdgqonfKtqqeE8XhXDUgFXd4ljE7t\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	public static  final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5E3cSmAZRktPuc5BjVQR\r\n"
			+ "iPcS8QW9713kJ0wQnla2povXPHtGPd4CdzRA+t63G/x8zaYegAOq+DB1mONOSio3\r\n"
			+ "qQfcL3DWj5UcOYQTHgnqeDubspSh5x9I6gLcK+hu/k/bpRIAY7/hgjkdqgUA0PL/\r\n"
			+ "fA6XtALdys+1QSxP6oMNjD3x1b38TxbIZpbMuEjl6IQN52m7+mC/HEEP5oz/MiBi\r\n"
			+ "H2Art/FO4SAOrQNuPOBjGI9WLjq2k2Beh8pEIuOHTrjJEkGVKUIxHyyurNKAqCvL\r\n"
			+ "yJi56hL/UpKQHzmD5zz9Hy66xX87VRBLvVyxxdyVQEIn5Xiyk+R7tPn0vKV80hce\r\n"
			+ "mwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
