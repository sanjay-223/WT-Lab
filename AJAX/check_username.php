<?php
$existingUsernames = ['user1', 'user2', 'user3','sanjay'];

if (isset($_POST['username'])) {
    $username = $_POST['username'];
    if (in_array($username, $existingUsernames)) {
        echo json_encode(['status' => 'not_available']);
    } else {
        echo json_encode(['status' => 'available']);
    }
}
?>
