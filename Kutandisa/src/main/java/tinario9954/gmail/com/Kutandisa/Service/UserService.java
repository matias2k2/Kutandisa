package tinario9954.gmail.com.Kutandisa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tinario9954.gmail.com.Kutandisa.Repository.UserRepository;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository _userRepository;
}
