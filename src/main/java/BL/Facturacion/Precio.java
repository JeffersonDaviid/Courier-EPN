package BL.Facturacion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JOptionPane;

import BL.GestionPaquete.Paquete;

public class Precio {
	private float subtotal = 0;
	private float total = 0;
	private float iva = 0;
	private String descripcion = "";

	public Precio() {
	}

	public float calcularPrecio(Paquete paquete) {
		subtotal = 0;
		total = 0;
		iva = 0;
		descripcion = "";

		cargarIvar();

		calcularPrecioCaracteristicas(paquete.getPeso(), paquete.getTamanio());

		calcularPrecioDistancia(paquete.getAgenciaOrigen(), paquete.getAgenciaDestino());

		if (paquete.getDomicilio() != null) {
			calcularServicioDomicilio();
		}

		return this.total = subtotal + (subtotal * (iva / 100));

	}

	/**
	 * DISTANCIA: 1ctv X km
	 */
	private void calcularPrecioDistancia(String origen, String destino) {
		String[] ciudades = {
				"Ambato", "Azogues", "Babahoyo", "Cuenca", "Esmeraldas", "Guayaquil", "Guaranda",
				"Ibarra", "Latacunga", "Loja", "Macará", "Macas", "Machala", "Manta", "Portoviejo",
				"Puyo", "Quito", "Riobamba", "Rumichaca", "Santo Domingo", "Tena", "Tulcán", "Zamora",
				"Lago Agrio"
		};

		int[][] distancias = {
				{ 0, 269, 220, 306, 390, 288, 99, 251, 47, 511, 701, 230, 382, 404, 369, 101, 136, 52,
						380, 205, 180,
						376, 575, 397 },
				{ 269, 0, 238, 37, 670, 213, 252, 520, 316, 242, 432, 219, 225, 409, 407, 333, 405, 217,
						649, 445, 412,
						645, 306, 664 },
				{ 220, 238, 0, 275, 392, 83, 121, 445, 267, 440, 427, 427, 216, 281, 246, 298, 304, 182,
						584, 207, 377,
						580, 504, 599 },
				{ 306, 37, 275, 0, 667, 250, 289, 557, 353, 205, 395, 231, 188, 446, 444, 370, 442, 254,
						686, 482, 449,
						682, 269, 700 },
				{ 390, 630, 392, 667, 0, 472, 489, 433, 343, 832, 819, 620, 608, 442, 407, 491, 318,
						442, 562, 185, 497,
						558, 896, 579 },
				{ 288, 213, 83, 250, 472, 0, 204, 535, 335, 415, 402, 432, 191, 196, 194, 349, 420, 233,
						664, 287, 428,
						660, 481, 679 },
				{ 99, 252, 121, 289, 489, 204, 0, 350, 146, 494, 684, 305, 337, 402, 367, 176, 235, 61,
						479, 328, 255,
						475, 558, 496 },
				{ 251, 220, 445, 557, 443, 535, 350, 0, 204, 762, 952, 479, 633, 505, 470, 350, 115,
						303, 129, 248, 271,
						125, 826, 365 },
				{ 47, 316, 267, 353, 343, 335, 146, 204, 0, 558, 748, 277, 42, 355, 320, 148, 89, 99,
						323, 158, 277,
						329, 622, 350 },
				{ 511, 242, 440, 205, 832, 415, 494, 762, 558, 0, 190, 436, 235, 611, 609, 519, 647,
						459, 891, 647, 598,
						887, 64, 904 },
				{ 701, 432, 427, 395, 819, 402, 684, 952, 748, 190, 0, 626, 222, 598, 596, 709, 837,
						649, 1081, 634,
						788, 1077, 254, 1084 },
				{ 230, 219, 427, 231, 620, 432, 305, 479, 277, 436, 626, 0, 419, 628, 626, 129, 366,
						245, 608, 435, 208,
						604, 326, 456 },
				{ 382, 225, 216, 188, 608, 191, 337, 633, 429, 235, 222, 419, 0, 387, 385, 444, 518,
						328, 762, 424, 523,
						758, 299, 766 },
				{ 404, 409, 281, 446, 442, 196, 402, 505, 355, 611, 598, 628, 387, 0, 35, 505, 390, 456,
						634, 257, 584,
						630, 675, 649 },
				{ 369, 407, 246, 444, 407, 194, 367, 470, 320, 609, 596, 626, 385, 35, 0, 470, 355, 427,
						599, 222, 549,
						595, 675, 614 },
				{ 101, 333, 298, 370, 491, 349, 176, 350, 148, 519, 709, 129, 444, 505, 470, 0, 237,
						116, 479, 306, 79,
						475, 455, 327 },
				{ 136, 404, 304, 442, 318, 420, 235, 115, 89, 647, 837, 366, 518, 390, 355, 237, 0, 188,
						244, 133, 186,
						240, 711, 259 },
				{ 52, 217, 182, 254, 442, 233, 61, 303, 99, 459, 649, 245, 328, 456, 427, 116, 188, 0,
						432, 257, 195,
						428, 523, 545 },
				{ 380, 649, 584, 686, 562, 664, 479, 129, 323, 891, 1081, 608, 762, 634, 599, 479, 244,
						432, 0, 377,
						400, 4, 955, 492 },
				{ 205, 445, 207, 482, 185, 287, 328, 248, 158, 647, 634, 435, 423, 257, 222, 306, 133,
						257, 377, 0, 312,
						373, 711, 394 },
				{ 180, 412, 377, 449, 497, 428, 255, 271, 227, 598, 778, 208, 523, 584, 549, 79, 186,
						195, 400, 312, 0,
						396, 534, 248 },
				{ 367, 645, 580, 682, 558, 660, 475, 125, 329, 887, 1077, 604, 758, 630, 595, 475, 240,
						428, 4, 373,
						396, 0, 951, 488 },
				{ 575, 306, 504, 269, 896, 481, 558, 826, 622, 64, 254, 326, 299, 675, 675, 455, 711,
						523, 955, 711,
						534, 951, 0, 781 },
				{ 397, 664, 599, 700, 579, 679, 496, 365, 350, 904, 1084, 456, 766, 649, 614, 327, 259,
						440, 492, 394,
						248, 488, 781, 0 }
		};

		int indiceInicial = -1;
		int indiceFinal = -1;
		for (int i = 0; i < ciudades.length; i++) {
			if (ciudades[i].equals(origen)) {
				indiceInicial = i;
			}
			if (ciudades[i].equals(destino)) {
				indiceFinal = i;
			}
		}

		// Validar si las ciudades fueron encontradas
		if (indiceInicial == -1 || indiceFinal == -1) {
			JOptionPane.showMessageDialog(null, "Ciudad no encontrada.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Obtener la distancia entre las ciudades
		int distancia = distancias[indiceInicial][indiceFinal];
		float precioDistancia = distancia * 0.01f; // 1ctv por km

		subtotal += precioDistancia;
	}

	/*
	 * TAMAÑO: grande 1$, mediano 0.75$, pequeño 0.5$
	 */
	private void calcularPrecioCaracteristicas(float peso, String tamanio) {
		float precioPeso = peso * 0.25f;

		float precioTamano = 0;
		switch (tamanio) {
			case "pequeño":
				precioTamano = 0.50f;
				break;
			case "mediano":
				precioTamano = 0.75f;
				break;
			case "grande":
				precioTamano = 1.0f;
				break;
			default:
				break;
		}

		subtotal += precioPeso + precioTamano;
	}

	private void calcularServicioDomicilio() {
		float valorDomicilio = 2.75f;

		subtotal += valorDomicilio;
		descripcion += "Servicio a Domicilio";
	}

	private void cargarIvar() {
		Properties props = new Properties();
		try {
			var in = Files.newInputStream(Paths.get("opciones.properties"));
			props.load(in);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error al cargar el archivo de propiedades: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		iva = Float.parseFloat(props.getProperty("IVA"));
	}

	public float getSubtotal() {
		return subtotal;
	}

	public float getTotal() {
		return total;
	}

	public float getIva() {
		return iva;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
