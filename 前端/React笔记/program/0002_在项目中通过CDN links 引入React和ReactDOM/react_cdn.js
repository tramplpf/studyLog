function formatName(user){
	return user.firstName + ' ' + user.lastName;
}

const user = {
	firstName: 'L',
	lastName:'PF'
};

const element = (
	<h1>
		Hello, {formatName(user)}
	</h1>
);