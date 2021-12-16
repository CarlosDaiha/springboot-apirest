package com.springboot.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "mi.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN PRIVATE KEY-----\r\n"
			+ "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC1FEZY6SqyscaB\r\n"
			+ "N7RJbpBcIUWPfqWC6vGXdjoJtBIp8YK8WwtN09U3g4VefgWoxBVr9Bqa0ih9hChY\r\n"
			+ "UUMGn9L5DPC1PnLRcXTgTyrG0LcZbmcqAVh0gc9Td6wp3c1KuT9pyihW+T2xTFPb\r\n"
			+ "gSjWj8GvljVGYDCHDeyae1AnCVyyE52w34hT+aZeq5z1lA7mhKwwogb6fgb89BuT\r\n"
			+ "aNM19mAJaYmpdTx0076CnJu8K+1pI1EqaRp8ziNvdtaGtxQRqtQQYdXZKX/PLbYR\r\n"
			+ "7bYIUOXLfEMMKNoTdHTlJuh8UBX/5u2Fa0erYi8o6Ngv1ZAQ69JNAtID7bbtAMAG\r\n"
			+ "qTyoXQN9AgMBAAECggEAJWdM+ageLP+qPn5EZAet043+2ZtiMlb39N6TsfXra5UK\r\n"
			+ "uX//54FacUdeSOy0nA3208/+H91JxlWCZO3SL7/bOx0IapO98VPjfcL0ldE+hQcI\r\n"
			+ "UcWp4RUAP6BAZHx/n5AA0IgUyZRdwS4AQ17cUeerbSrUkdckJv2CEk3m+k1Fg7XO\r\n"
			+ "5TjsKZeD2RmUQlyOMrWWlKs7O4f62qxrSnz5tnQAe7FzIS18VgTMtYc9pD1Mcf2t\r\n"
			+ "h5dYeYtvTG7vop9egvaRzrFywTL9pBjwTjS53XInjccXVFiAKmIALkxyYG/ue9Tg\r\n"
			+ "wRrmehv6Mnx6sY++hv8v3XkilmFkK2eGyesjymaMIQKBgQDII0bPar6R5pZ+wkFa\r\n"
			+ "02pfhuAHcrnyb7uAEiaMRNMqlDOgPKMgomPdBQML+1tBDAUjVf6Y/atv65uGmF90\r\n"
			+ "4k908JpZ2OY7JUj1U46IOR5a1RT/uf684gSk4AvjxHpd37tCadaB1Ii6NK7HAiBu\r\n"
			+ "LQZUa0VrBpTYg5aJte4r3hm5YQKBgQDnny12aAKSKYJy128w/obw76ytmWCXwt7d\r\n"
			+ "8yAJDF1w6N/8DL8+srnO55J1Ez5fCqGmsC48ZhD4ecl39suZX4L+d1YHtgryCm+z\r\n"
			+ "o/UiqIA5PagN1AmbLwXCe85db32T2/ixWAk240Kwh0Td0iDnO96+QXwyX/P+NZrn\r\n"
			+ "Xlyti6gznQKBgCbHxyHL4k9tKf437+gEjVkjTmfDEErs4Z0oZzXI5E4c14AWH9nj\r\n"
			+ "/YvHO9bnhsAs7xXwxNuqU7zlH4bOIbkJXTIgqRf90mbli6SV40l8H+ij32TKCpVZ\r\n"
			+ "CmNUUpl46ekkwClXTsxrfW7vZGqFe/k9WjujaZkadl8Z6GKY0STI7Z0hAoGBALBb\r\n"
			+ "dtYtI6f+iyC+AB+h7UUOeMBFhFKJQgBk2gOJsqwB5GmZmxQ2KVvs3ord+CONiL/O\r\n"
			+ "baX3YPyQXmJFO4iwPKFcY9jDN1pLr/lr4X5eJiNvWsIMrLPH/e6zLdHezhMC7jy5\r\n"
			+ "92ofZ+vZUwpCsGLgJx1d5x7ECJeKYUPBiXdqWsvRAoGAbe/qgZLd7qXUEp/upSaN\r\n"
			+ "BqgWugaUFFh+n82MXdsHBKYvunpIt5+hyztBjAZF/Z/+dgzLNygL+A8MHPqe1p3K\r\n"
			+ "B7pDHLD5GsIzq1Hl77iMwDSwdE6ey+BnwmsA+iHuE6N+fQ6pBcsJKUlwqWG0aLtN\r\n"
			+ "kqcRy3onoSGtbUvPHwiyfWk=\r\n"
			+ "-----END PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtRRGWOkqsrHGgTe0SW6Q\r\n"
			+ "XCFFj36lgurxl3Y6CbQSKfGCvFsLTdPVN4OFXn4FqMQVa/QamtIofYQoWFFDBp/S\r\n"
			+ "+QzwtT5y0XF04E8qxtC3GW5nKgFYdIHPU3esKd3NSrk/acooVvk9sUxT24Eo1o/B\r\n"
			+ "r5Y1RmAwhw3smntQJwlcshOdsN+IU/mmXquc9ZQO5oSsMKIG+n4G/PQbk2jTNfZg\r\n"
			+ "CWmJqXU8dNO+gpybvCvtaSNRKmkafM4jb3bWhrcUEarUEGHV2Sl/zy22Ee22CFDl\r\n"
			+ "y3xDDCjaE3R05SbofFAV/+bthWtHq2IvKOjYL9WQEOvSTQLSA+227QDABqk8qF0D\r\n"
			+ "fQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
