package pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.service;

import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.dto.ClienteDTO;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.entity.ClienteEntity;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.mapper.ClienteMapper;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.producer.ClienteMessageProducer;
import pe.edu.galaxy.galaxy.java.arq.ms.ms_negocio_gestion_cliente.respository.ClienteRepository;
import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;

	private final ApplicationEventPublisher applicationEventPublisher;

	@Override
	public Optional<ClienteDTO> findById(Long id) throws ClienteException {
		String msg = String.format("No existe cliente con id => {}", id);
		ClienteEntity clienteEntity = this.clienteRepository.findById(id).orElseThrow(() -> new ClienteException(msg));
		ClienteDTO clienteDTO = clienteMapper.toDTO(clienteEntity);
		return Optional.ofNullable(clienteDTO);
	}

	@Override
	public List<ClienteDTO> findAll() throws ClienteException {
		return clienteMapper.toLstDTO(clienteRepository.findAll());
	}

	@Override
	public Long save(ClienteDTO clienteDTO) throws ClienteException {
		try {
			ClienteEntity clienteEntity = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
			if (isNull(clienteEntity)) {
				throw new ClienteException("Error al resgitrar cliente");
			}
			// Prooducir el mensaje
			clienteDTO.setId(clienteEntity.getId());
			var clienteMessage = clienteMapper.toMessage(clienteDTO);
			//clienteMessageProducer.send(clienteMapper.toMessage(clienteDTO));
			applicationEventPublisher.publishEvent(clienteMessage);

			return clienteEntity.getId();
		}catch (Exception e) {
			throw new ClienteException("Error al resgitrar cliente", e);
		}
	}
}
