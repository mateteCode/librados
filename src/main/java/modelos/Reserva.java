package modelos;

import java.time.LocalDateTime;

public class Reserva extends Solicitud {

	public Reserva(int id, int id_ofrecido, int id_usuario, LocalDateTime fecha) {
		super(id, id_ofrecido, id_usuario, fecha);
	}

}
