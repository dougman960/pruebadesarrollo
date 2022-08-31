package com.dmartinezl.auth;

public class JwtConfig {
	
	public static final String   RSA_PRIVATE  = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEA62zXCYCyd1pwWiqaOG3HpF8Wf0qktkyHuZZtwbLB/u785X5g\r\n"
			+ "TFhDeL4vnHYscdl9BY9z/CbpFOuQZDF7wOgsVsKLkuXAOePm3iXFywSj/sheU3Et\r\n"
			+ "DiE44d9vAdF4/9SHdIHQJwaHGcd+NNjd7xxvKVBKrdfMRu9EoikOEcd2svDQwOv2\r\n"
			+ "B4AmgLX6ISthFqKB/ckC/TRkAUG4owRjLgw25Gl/VaauZSwwgN7eZAfbX+85LTCx\r\n"
			+ "CuMlgzT6hLghwkjMZ+L5BzRwyb34RE21gNv8Gx/MmXuNqmKgNd+nkphBfiE/8Rnw\r\n"
			+ "CUmxfzU8n1/zfBrTSCruZPQTajZFDHEyX+fflwIDAQABAoIBADIEudtHAKPjDyPZ\r\n"
			+ "EVMT3+rIWRtKXJxuvhdsIn2Y4Sas2AZaR1NxHUS2A5+Wa/L0Zl+cDuRvz+2l7tOa\r\n"
			+ "v9RIf8MfKlBXh/PEu/ROyitMHRuwrnnD/fKWlGNI+WjFfJO+L9lNC1B/ToznmaTY\r\n"
			+ "vq5iuCtq57LvunMHuulJF7gnTMzPfPk78mKDNSlAOInaZ4e7T2rvntN7nrL0ODxR\r\n"
			+ "GBW/BON+TBdGly6lUnlwWQTYgvMwfbkr1wMtNjvX8PCuKuUzqgupQfatJEmSGlX8\r\n"
			+ "LNjxirLVJa3drrtrff+xGd47CvkoqM12E/5rj+G9pDyO6NFfdrUpl/lYyS6BWy01\r\n"
			+ "9loDpIECgYEA9eCWkNdUFr6pbnROLcVyHMEFhgVnWjpiaHub8tSdzU15n13pn7EF\r\n"
			+ "eKCCyWZos0dRx+NRVqN7qzMp7bdj2G3kK7tZTTgODh4o706l3mi+dtTtb2DpF81l\r\n"
			+ "zwP+ZnTPFBh8ZUB3DIWv7UXxs+F8uKf5Jx57oBiAp6VUTj6Zr5TOS8cCgYEA9R4X\r\n"
			+ "jaomLybsX/P/qpApklnUl1ABp3owE8QaCR4ZbEOzzHM9aq6gVhaU9Vh92Id0BYTT\r\n"
			+ "EXffnp+AjkxaUx9SegDUbv238bu3rM9LRa5RX9WbTJ5duEBgJX00G4xzLztdMC4x\r\n"
			+ "dce1cxUzPrfMoIg7HdjuFwO0KkGQOleQsqtwrbECgYEAiDXc82x2hwskra38yVqC\r\n"
			+ "du9vcel4cgG6FouzvviOWve6ktDh5beZglPZYF09T2QJKCUEIGz8y8DST4Cy7Wkj\r\n"
			+ "aB6nwCF3l9aZcsktFmMMcKRQzMzxFGCTL/XUb0nylf1inGz0Bpng9h8zYSVfhKR5\r\n"
			+ "YHSApBYu37C1XYtMdHqJNm0CgYBAN9wP324VmGsBUJnBA/gAQcyyv+FPEXIbG5t+\r\n"
			+ "nAYpGSu3+tEybAHRzCTGiqKd4g8BiyUJRJCvrDYwEczwThp7oFAHrC1PBdE/Uyfz\r\n"
			+ "X5IuO3ZugmcnaKZH7B+EwC1FSJZHkzKeGu5s8jb0zY6s2EQ0s6rdGLlRANBamKpu\r\n"
			+ "RQBGYQKBgErtQjNsVrkaViQifgmJGIIexcWe6qoOk3Dk4h3E7BIJScWesIMD1CvO\r\n"
			+ "rkeROlhwGfe9ozZ2LetDRHqJlFO+ulwoY42X9kIEYte2ndg3oCcoGXcHS0UmoZTs\r\n"
			+ "Z0btgWPgvwMIc3wNIPP3dMnevj7o1IkdZXgL3TToeuVKeJO+ZMpq\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA62zXCYCyd1pwWiqaOG3H\r\n"
			+ "pF8Wf0qktkyHuZZtwbLB/u785X5gTFhDeL4vnHYscdl9BY9z/CbpFOuQZDF7wOgs\r\n"
			+ "VsKLkuXAOePm3iXFywSj/sheU3EtDiE44d9vAdF4/9SHdIHQJwaHGcd+NNjd7xxv\r\n"
			+ "KVBKrdfMRu9EoikOEcd2svDQwOv2B4AmgLX6ISthFqKB/ckC/TRkAUG4owRjLgw2\r\n"
			+ "5Gl/VaauZSwwgN7eZAfbX+85LTCxCuMlgzT6hLghwkjMZ+L5BzRwyb34RE21gNv8\r\n"
			+ "Gx/MmXuNqmKgNd+nkphBfiE/8RnwCUmxfzU8n1/zfBrTSCruZPQTajZFDHEyX+ff\r\n"
			+ "lwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
