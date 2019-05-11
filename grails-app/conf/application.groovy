
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'webec.SecUser'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'webec.SecUserSecRole'
grails.plugin.springsecurity.authority.className = 'webec.SecRole'

grails.plugin.springsecurity.logout.postOnly = false // allow logout via get url /logout

final statics = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = statics

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

// config types are 'Annotation', 'Requestmap', or 'InterceptUrlMap'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.interceptUrlMap = statics + [
		[pattern: "/static/**",  access: ["permitAll"]],
		[pattern: "/login/auth", access: ["permitAll"]],
//		[pattern: "/question/**" , access: ['ROLE_ADMIN']], // cannot use constant here :-(
//		[pattern: "/answer/**"   , access: ['ROLE_ADMIN']],
//		[pattern: "/answer/**", access: ['ROLE_ADMIN', 'ROLE_GUEST']], // secured for testing security
//		[pattern: "/InPlaceCalculator.html" ,   access: ['permitAll']], // unsecured for ease of testing
//		[pattern: "/inPlaceCalculator/**" ,     access: ['permitAll']],
//		[pattern: "/multiplicationCircle.html", access: ['permitAll']],
//		[pattern: "/multiplicationCircle/**" ,  access: ['permitAll']],
//		[pattern: "/static/Temperatures.html",  access: ['permitAll']],
//		[pattern: "/**", access: ['ROLE_ADMIN', 'ROLE_GUEST']], // default: all is secured
		[pattern: "/question/index"   , access: ['ROLE_ADMIN']],
		[pattern: "/**", access: ['permitAll']], // default: all is open
]