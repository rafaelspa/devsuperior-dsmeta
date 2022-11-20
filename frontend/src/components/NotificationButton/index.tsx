import notificationIcon from "../../assets/img/notificationIcon.svg";
import 'styles.css';

function NotificationButton() {
    return (
        <>
            <div className="dsmeta-red-btn-container">
                <div className="dsmeta-red-btn">
                    <img src={notificationIcon} alt="Notificar" />
                </div>
            </div>
        </>
    )
}

export default NotificationButton
